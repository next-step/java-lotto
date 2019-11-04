package lotto.domain;

import java.util.Arrays;

public enum LottoRank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NOT_MATCH(0, 0);

    private int matchCount;
    private int winning;

    LottoRank(int matchCount, int winning) {
        this.matchCount = matchCount;
        this.winning = winning;
    }

    public static LottoRank find(long matchCount, boolean matchBonusNumber) {
        LottoRank rank = Arrays.stream(LottoRank.values())
                .filter(lottoRank -> lottoRank.matchCount == matchCount)
                .findFirst()
                .orElse(NOT_MATCH);

        if (matchCount == 5) {
            return matchBonusNumber ? SECOND : THIRD;
        }

        return rank;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getWinning() {
        return winning;
    }
}
