package lotto.domain;

import java.text.DecimalFormat;

public enum EqualNumbersMoney {
    EQUALS(0, 0),
    EQUALS_3(3, 5000),
    EQUALS_4(4, 50000),
    EQUALS_5(5, 1500000),
    EQUALS_5_BONUS(5, 3000000),
    EQUALS_6(6, 20000000);

    private final int equalNumbers;
    private final long winOfMoney;
    private int equalCount;
    private long winAmountTotal;

    EqualNumbersMoney(int equalNumbers, long winOfMoney) {
        this.equalNumbers = equalNumbers;
        this.winOfMoney = winOfMoney;
    }

    public float getWinAmountTotal() {
        return winAmountTotal;
    }

    public void setEqualCount() {
        this.equalCount++;
        setWinAmountTotal(winOfMoney);
    }

    private void setWinAmountTotal(float winOfMoney) {
        winAmountTotal += winOfMoney;
    }

    public String toString() {
        DecimalFormat df = new DecimalFormat("#,###");
        return this.equalNumbers + "개 일치 (" + df.format(this.winOfMoney) + "원) - " + this.equalCount + "개";
    }
}
