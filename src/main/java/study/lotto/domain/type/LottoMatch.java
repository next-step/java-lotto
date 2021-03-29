package study.lotto.domain.type;

import java.util.Arrays;
import java.util.List;

/**
 * 고정된 결과물 출력을 위한 당첨 값 관리
 */
public enum LottoMatch {

    RANK_FIRST(6, 2_000_000_000),
    RANK_BONUS(5, 30_000_000),
    RANK_SECOND(5, 1_500_000),
    RANK_THIRD(4, 50_000),
    RANK_FOURTH(3, 5_000),
    RANK_ETC(0, 0);

    private final long matchCount;
    private final long winningReward;

    LottoMatch(final long matchCount, final long winningReward) {
        this.matchCount = matchCount;
        this.winningReward = winningReward;
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

    public boolean isBonusNumber(final boolean bonusNumber) {
        return !this.equals(RANK_BONUS) || bonusNumber;
    }

    private boolean isMatchCount(final long matchCount) {
        return this.matchCount == matchCount;
    }

    public long getWinningReward() {
        return winningReward;
    }

    @Override
    public String toString() {
        return String.valueOf(matchCount);
    }
}
