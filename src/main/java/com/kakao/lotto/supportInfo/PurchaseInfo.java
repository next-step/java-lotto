package com.kakao.lotto.supportInfo;

public class PurchaseInfo {
    private final int money;

    private static final int BASE_MONEY = 1000;

    public PurchaseInfo(int money) {
        this.money = money;
    }

    public int getTicketNumber() {
        return money / BASE_MONEY;
    }

    public int getMoney() {
        return money;
    }
}
