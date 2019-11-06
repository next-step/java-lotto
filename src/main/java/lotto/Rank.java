package lotto;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private int countOfMatch;
    private int winningMoney;

    private Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        if (SECOND.getCountOfMatch() == countOfMatch || THIRD.getCountOfMatch() == countOfMatch) {
            return validateBonus(matchBonus);
        }
        return Arrays.stream(values())
                .filter(r -> r.getRankValue(r, countOfMatch) != null).findAny()
                .orElse(MISS);
    }

    public static Rank validateBonus(boolean matchBonus) {
        if (matchBonus) {
            return SECOND;
        }
        return THIRD;
    }

    public Rank getRankValue(Rank rank, int countOfMatch) {
        if (rank.getCountOfMatch() == countOfMatch) {
            return rank;
        }
        return null;
    }
}
