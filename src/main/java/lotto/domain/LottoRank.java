package lotto.domain;

import java.util.Arrays;

public enum LottoRank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private final int matchingCount;
    private final int winningPrize;

    LottoRank(int matchingCount, int winningPrize) {
        this.matchingCount = matchingCount;
        this.winningPrize = winningPrize;
    }

    public int matchingCount() {
        return matchingCount;
    }

    public int winningPrize() {
        return winningPrize;
    }

    public static LottoRank valueOf(int matchingCount, boolean sameBonusNumber) {
        if (matchingCount == SECOND.matchingCount) {
            return secondOrThird(sameBonusNumber);
        }

        return Arrays.stream(values())
                .filter(e -> e.matchingCount == matchingCount)
                .findFirst()
                .orElse(MISS);
    }

    private static LottoRank secondOrThird(boolean sameBonusNumber) {
        if (sameBonusNumber) {
            return SECOND;
        }
        return THIRD;
    }
}
