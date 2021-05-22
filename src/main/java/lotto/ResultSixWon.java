package lotto;

public class ResultSixWon {
    private final String sixWonText = "6개 일치 (2000000000원)";
    private final int sixWonMoney = 2000000000;
    private int count = 0;

    public int getCount() {
        return count;
    }

    void won() {
        count++;
    }

    public int getWonMoney() {
        return count * sixWonMoney;
    }

    public String getResult() {
        return sixWonText + "-" + count + "개";
    }


}
