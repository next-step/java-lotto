package lotto;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private final int countOfMatch;
    private final int winningMoney;

    Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static Rank valueOf(long countOfMatch, boolean matchBonus) {
        Rank result = Arrays.stream(values())
                .filter(rank -> rank.countOfMatch == countOfMatch)
                .findFirst()
                .orElse(MISS);
        if(isTHIRD(matchBonus, result)){
            return THIRD;
        }
        return result;

    }

    private static boolean isTHIRD(boolean matchBonus, Rank result) {
        return result.equals(SECOND) && !matchBonus;
    }

}
