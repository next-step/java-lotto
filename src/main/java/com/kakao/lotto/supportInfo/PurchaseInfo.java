package com.kakao.lotto.supportInfo;

public class PurchaseInfo {
    private final int ticketNumber;

    private static final int BASE_MONEY = 1000;

    public PurchaseInfo(int money) {
        this.ticketNumber = money / BASE_MONEY;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }
}
