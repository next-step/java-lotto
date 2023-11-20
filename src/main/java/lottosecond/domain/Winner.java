package lottosecond.domain;

import java.util.Arrays;

public enum Winner {

    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false,  1_500_000),
    FOURTH(4, true, 50_000),
    FIFTH(3, false, 5_000),
    NONE(-1, false, 0);

    private final int normalNumberMatchCount;
    private final boolean bonusNumberMatch;
    private final long price;

    Winner(int normalNumberMatchCount, boolean bonusNumberMatch, int price) {
        this.normalNumberMatchCount = normalNumberMatchCount;
        this.bonusNumberMatch = bonusNumberMatch;
        this.price = price;
    }

    public static Winner calculateWinner(int matchCount, boolean matchBonusBall) {
        return Arrays.stream(Winner.values())
                .filter(winner -> {
                    if (matchCount == 5) {
                        return winner.normalNumberMatchCount == matchCount && winner.bonusNumberMatch == matchBonusBall;
                    }
                    return winner.normalNumberMatchCount == matchCount;
                })
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
