package step2.model;

import java.util.Arrays;

public enum Rank {
    FIRST(6, false, 2_000_000_000),
    SECOND(5,true,  30_000_000),
    THIRD(5, false, 15_000_000),
    FOURTH(4,false,  50000),
    FIFTH(3, false, 5000),
    MISS(0, false, 0);

    private final int countOfMatch;
    private final boolean isBonus;
    private final int winningPrice;

    Rank(int countOfMatch, boolean isBonus, int winningPrice) {
        this.countOfMatch = countOfMatch;
        this.isBonus = isBonus;
        this.winningPrice = winningPrice;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningPrice() {
        return winningPrice;
    }

    public boolean getBonus() {
        return isBonus;
    }

    public static Rank getRank(int countOfMatch, boolean matchBonus){
        return Arrays.stream(Rank.values())
                    .filter(rank -> (countOfMatch == rank.getCountOfMatch() && matchBonus == rank.getBonus()))
                    .findAny()
                    .orElse(MISS);
    }
}
