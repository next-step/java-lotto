package lotto.domain;

public enum EqualNumbersMoney {
    EQUALS(0, 0),
    EQUALS_3(3, 5000),
    EQUALS_4(4, 50000),
    EQUALS_5(5, 1500000),
    EQUALS_5_BONUS(5, 3000000),
    EQUALS_6(6, 20000000);

    private int equalNumbers;
    private final float winOfMoney;
    private int equalCount;
    private static float winAmountTotal;

    EqualNumbersMoney(int equalNumbers, float winOfMoney) {
        this.equalNumbers = equalNumbers;
        this.winOfMoney = winOfMoney;
    }

    public void setEqualCount() {
        this.equalCount++;
        setWinAmountTotal(winOfMoney);
    }

    private void setWinAmountTotal(float winOfMoney) {
        winAmountTotal += winOfMoney;
    }

    public float getWinAmountTotal() {
        return winAmountTotal;
    }

    public String toString() {
        return this.equalNumbers + "개 일치 (" + (int)this.winOfMoney + "원) - " + this.equalCount + "개";
    }
}