package lotto;

public class ResultFourWon {
    private final String fourWonText = "4개 일치 (50000원)";
    private final int fourWonMoney = 50000;
    private int count=0;

    public int getCount() {
        return count;
    }

    void won() {
        count++;
    }

    public int getWonMoney() {
        return count * fourWonMoney;
    }

    public String getResult() {
        return fourWonText + "-" + count + "개";
    }

}
