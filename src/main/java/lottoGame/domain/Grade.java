package lottoGame.domain;


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

        if (countOfMatch == 6 || (countOfMatch == 5 && matchBonus)) {
            return grades[FIRST.getCountOfMatch() - countOfMatch];
        }
        if (countOfMatch > 2) {
            return grades[FIRST.getCountOfMatch() - countOfMatch + 1];
        }
        return MISS;
    }
}
