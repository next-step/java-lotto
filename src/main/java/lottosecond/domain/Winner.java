package lottosecond.domain;

import java.util.Arrays;

public enum Winner {

    NONE(-1, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5,  1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    private final int normalNumberMatchCount;
    private final long price;

    Winner(int normalNumberMatchCount, int price) {
        this.normalNumberMatchCount = normalNumberMatchCount;
        this.price = price;
    }

    public static Winner calculateWinner(int matchCount, boolean matchBonusBall) {
        if (matchCount == SECOND.normalNumberMatchCount && matchBonusBall) {
            return Winner.SECOND;
        }

        return Arrays.stream(Winner.values())
                .filter(winner -> winner.normalNumberMatchCount == matchCount)
                .findFirst()
                .orElse(Winner.NONE);
    }

    public long getPrice() {
        return price;
    }

    public int getNormalNumberMatchCount() {
        return normalNumberMatchCount;
    }
}
