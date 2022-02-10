package lotto.domain;

import java.util.Arrays;

public enum Ranking {

    FIRST(2_000_000_000, 6),
    SECOND(30_000_000, 5),
    THIRD(1_500_000, 5),
    FOURTH(50_000, 4),
    FIFTH(5_000, 3),
    FAIL(0, 0);

    private static final int SECOND_COUNTS = 5;

    private final int winnerPrice;
    private final int normalNumberMatchCount;

    Ranking(final int winnerPrice, final int normalNumberMatchCount) {
        this.winnerPrice = winnerPrice;
        this.normalNumberMatchCount = normalNumberMatchCount;
    }

    public static Ranking judgeRanking(final int normalNumberMatchCount, final boolean isMatchedBonusNumber) {
        if (normalNumberMatchCount == SECOND_COUNTS
            && !isMatchedBonusNumber) {
            return THIRD;
        }

        return Arrays.stream(Ranking.values())
            .filter(rank -> rank.equals(normalNumberMatchCount))
            .findFirst()
            .orElse(FAIL);
    }

    private boolean equals(final int normalNumberMatchCount) {
        return this.normalNumberMatchCount == normalNumberMatchCount;
    }

    public int multiplyCountAndWinnerPrice(final int count) {
        return winnerPrice * count;
    }

    public boolean isFail() {
        return this == FAIL;
    }

    public int getNormalNumberMatchCount() {
        return normalNumberMatchCount;
    }

    public int getWinnerPrice() {
        return winnerPrice;
    }
}
