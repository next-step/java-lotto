package step3.domain;


public enum Grade {

    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    MISS(0, 0);

    private int countOfMatch;
    private int winningMoney;

    Grade(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static Grade valueOf(int countOfMatch, boolean matchBonus) {

        Grade[] grades = values();

        if (countOfMatch == 6) return grades[0];
        if (countOfMatch == 5 && matchBonus) return SECOND;
        if (countOfMatch == 5) return THIRD;
        if (countOfMatch == 4) return FOURTH;
        if (countOfMatch == 3) return FIFTH;

        return MISS;
    }
}
