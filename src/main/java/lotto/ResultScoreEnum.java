package lotto;

public enum ResultScoreEnum {

    FIRST(6, 2000000000, "6개 일치 (2000000000원)"),
    SECOND(5, 30000000, "5개 일치, 보너스 볼 일치 (30000000원)"),
    THIRD(5, 150000, "5개 일치 (150000원)"),
    FOURTH(4, 50000, "4개 일치 (50000원)"),
    FIFTH(3, 5000, "3개 일치 (5000원)"),
    MISS(0, 0, "0개 일치 (0원)");

    private String printResult;
    private int countOfMatch;
    private int winningMoney;

    ResultScoreEnum(int countOfMatch, int winningMoney, String printResult) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
        this.printResult = printResult;
    }

    public void printResult(int wonCount) {
        System.out.println(printResult + "-" + wonCount + "개");
    }

    public int getWonMoney(int wonCount) {
        return winningMoney * wonCount;
    }

    public static ResultScoreEnum valueOf(int countOfMatch, boolean matchBonus) {
        if (countOfMatch == 0)
            return MISS;
        if (countOfMatch == 3)
            return FIFTH;
        if (countOfMatch == 4)
            return FOURTH;
        if (countOfMatch == 5 && !matchBonus)
            return THIRD;
        if (countOfMatch == 5 && matchBonus)
            return SECOND;
        if (countOfMatch == 6)
            return FIRST;

        return MISS;
    }
}
