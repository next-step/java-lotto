package study.lotto.domain.type;

import java.util.Arrays;
import java.util.List;

/**
 * 고정된 결과물 출력을 위한 당첨 값 관리
 */
public enum LottoMatch {

    RANK_FIRST(6, 2_000_000_000, "%s 개 일치 (%s원) - %s개"),
    RANK_BONUS(5, 30_000_000, "%s 개 일치, 보너스볼 일치(%s원) - %s개"),
    RANK_SECOND(5, 1_500_000, "%s 개 일치 (%s원) - %s개"),
    RANK_THIRD(4, 50_000, "%s 개 일치 (%s원) - %s개"),
    RANK_FOURTH(3, 5_000, "%s 개 일치 (%s원) - %s개"),
    RANK_ETC(0, 0, "");

    private final long matchCount;
    private final long winningReward;
    private final String guideText;

    LottoMatch(final long matchCount, final long winningReward, String guideText) {
        this.matchCount = matchCount;
        this.winningReward = winningReward;
        this.guideText = guideText;
    }

    public static List<LottoMatch> all() {
        return Arrays.asList(RANK_FOURTH, RANK_THIRD, RANK_SECOND, RANK_BONUS, RANK_FIRST);
    }

    public static LottoMatch of(final long matchCount, final boolean bonusNumber) {
        return Arrays.stream(LottoMatch.values())
                .filter(lottoMatch -> lottoMatch.isMatchCount(matchCount))
                .filter(lottoMatch -> lottoMatch.isBonusNumber(bonusNumber))
                .findFirst()
                .orElse(RANK_ETC);
    }

    private boolean isBonusNumber(boolean bonusNumber) {
        return !this.equals(RANK_BONUS) || bonusNumber;
    }

    public static LottoMatch of(final long matchCount) {
        return Arrays.stream(LottoMatch.values())
                .filter(lottoMatch -> lottoMatch.isMatchCount(matchCount))
                .findAny()
                .orElse(RANK_ETC);
    }

    private boolean isMatchCount(final long matchCount) {
        return this.matchCount == matchCount;
    }

    public long getWinningReward() {
        return winningReward;
    }

    public String guideLine() {
        return guideText;
    }

    @Override
    public String toString() {
        return String.valueOf(matchCount);
    }
}
