package lotto.oop.domain;

public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
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
        if (countOfMatch == 6) {
            return FIRST;
        }
        if (countOfMatch == 5 && matchBonus == true) {
            return SECOND;
        }
        if (countOfMatch == 5 || (countOfMatch == 4 && matchBonus == true))
            return THIRD;
        if (countOfMatch == 4 || (countOfMatch == 3 && matchBonus == true))
            return FOURTH;
        if (countOfMatch == 3 || (countOfMatch == 2 && matchBonus == true))
            return FIFTH;
        return MISS;
    }
}
