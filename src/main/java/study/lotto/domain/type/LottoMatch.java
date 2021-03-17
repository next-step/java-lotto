package study.lotto.domain.type;

import java.util.Arrays;
import java.util.List;

/**
 * 고정된 결과물 출력을 위한 당첨 값 관리
 */
public enum LottoMatch {

    RANK_FIRST(6, 2_000_000_000),
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
        return Arrays.asList(RANK_FOURTH, RANK_THIRD, RANK_SECOND, RANK_FIRST);
    }

    public static LottoMatch of(final long matchCount) {
        return Arrays.stream(LottoMatch.values())
                .filter(lottoMatch -> isMatchCount(matchCount, lottoMatch))
                .findAny()
                .orElse(RANK_ETC);
    }

    private static boolean isMatchCount(final long matchCount, final LottoMatch lottoMatch) {
        return lottoMatch.matchCount == matchCount;
    }

    public long getWinningReward() {
        return winningReward;
    }

    @Override
    public String toString() {
        return String.valueOf(matchCount);
    }
}
