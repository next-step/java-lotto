package lotto;

import java.util.Arrays;

public enum Rank {
    FIFTH("5등", 3, 5_000),
    FOURTH("4등", 4, 50_000),
    THIRD("3등", 5, 1_500_000),
    SECOND("2등", 5, 30_000_000),
    FIRST("1등", 6, 2_000_000_000);

    private String name;
    private int matchCount;
    private int winningAmount;

    Rank(String name, int matchCount, int winningAmount) {
        this.name = name;
        this.matchCount = matchCount;
        this.winningAmount = winningAmount;
    }

    public String getName() {
        return name;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getWinningAmount() {
        return winningAmount;
    }

    public static Rank valueOf(int matchCount, boolean matchBonus) {
        Rank rank = Arrays.stream(values())
                          .filter(it -> it.matchCount == matchCount)
                          .findFirst()
                          .orElseThrow(IllegalAccessError::new);

        if (matchCount == 5) {
            rank = checkBonusBall(rank, matchBonus);
        }

        return rank;
    }

    private static Rank checkBonusBall(Rank rank, boolean matchBonus) {
        if (matchBonus) {
            rank = SECOND;
        }
        return rank;
    }
}
