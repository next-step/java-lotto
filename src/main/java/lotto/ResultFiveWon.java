package lotto;

public class ResultFiveWon {
    private final String fiveWonText = "5개 일치 (150000원)";
    private final int fiveWonMoney = 150000;
    private int count=0;

    public int getCount() {
        return count;
    }

    void won() {
        count++;
    }

    public int getWonMoney() {
        return count * fiveWonMoney;
    }

    public String getResult() {
        return fiveWonText + "-" + count + "개";
    }


}
