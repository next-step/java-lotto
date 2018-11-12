package lotto.enums;

public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    MISS(0, 0);

    private int countOfMatch;
    private int winningMoney;

    Rank(int countOfMatch, int winningMoney) {
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
        Rank[] ranks = values();

        for (int i = 0; i < ranks.length; i++) {
            if (countOfMatch == SECOND.getCountOfMatch() && matchBonus) {
                return SECOND;
            }

            if (countOfMatch == SECOND.getCountOfMatch() && !matchBonus) {
                return THIRD;
            }

            if (ranks[i].getCountOfMatch() == countOfMatch) {
                return ranks[i];
            }
        }

        return MISS;
    }
}
