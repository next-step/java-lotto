package lotto.domain;

public enum EqualNumbersMoney {
    EQUALS_3(5000),
    EQUALS_4(50000),
    EQUALS_5(1500000),
    EQUALS_5_BONUS(3000000),
    EQUALS_6(20000000);

    private final float winOfMoney;

    EqualNumbersMoney(float winOfMoney) {
        this.winOfMoney = winOfMoney;
    }

    public float getWinOfMoney() {
        return this.winOfMoney;
    }
}