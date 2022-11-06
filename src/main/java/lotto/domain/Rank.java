package lotto.domain;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private final int countOfMatch;
    private final int winningMoney;

    private Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public int countOfMatch() {
        return countOfMatch;
    }

    public int winningMoney() {
        return winningMoney;
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        Rank[] ranks= Rank.values();
        if (countOfMatch == 5 && matchBonus == true) {
            return SECOND;
        }

        for (Rank rank : ranks) {
            if (rank.countOfMatch == countOfMatch) {
                return rank;
            }
        }
        return MISS;
    }
}
