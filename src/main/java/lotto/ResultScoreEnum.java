package lotto;

public enum ResultScoreEnum {
    THREE("3개 일치 (5000원)", 5000),
    FOUR("4개 일치 (50000원)", 50000),
    FIVE("5개 일치 (150000원)", 150000),
    SIX("6개 일치 (2000000000원)", 2000000000);

    private String printResult;
    private int prizeMoney;

    ResultScoreEnum(String text, int i) {
        this.printResult = text;
        this.prizeMoney = i;
    }

    public void printResult(int wonCount) {
        System.out.println(printResult + "-" + wonCount + "개");
    }

    public int getWonMoney(int wonCount) {
        return prizeMoney * wonCount;
    }
}
