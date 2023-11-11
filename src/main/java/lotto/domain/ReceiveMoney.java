package lotto.domain;

public enum ReceiveMoney {
    MATCH_6_RECEIVE_MONEY(2000000000),
    MATCH_5_RECEIVE_MONEY(1500000),
    MATCH_4_RECEIVE_MONEY(50000),
    MATCH_3_RECEIVE_MONEY(5000),
    ;

    private final int money;

    ReceiveMoney(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }
}
