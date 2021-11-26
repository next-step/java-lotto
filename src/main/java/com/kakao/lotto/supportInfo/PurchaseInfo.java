package com.kakao.lotto.supportInfo;

import java.util.Collections;
import java.util.List;

public class PurchaseInfo {
    private final int money;
    private final List<List<Integer>> pickedLotteries;

    private static final int BASE_MONEY = 1000;

    public PurchaseInfo(int money) {
        this.money = money;
        this.pickedLotteries = Collections.emptyList();
    }

    public PurchaseInfo(int money, List<List<Integer>> pickedLotteries) {
        this.money = money;
        this.pickedLotteries = pickedLotteries;
    }

    public int getTotalTicketCount() {
        return money / BASE_MONEY;
    }

    public int getPickedTicketCount(){
        return this.pickedLotteries.size();
    }

    public int getRandomTicketCount(){
        return getTotalTicketCount() - getPickedTicketCount();
    }

    public int getMoney() {
        return money;
    }

    public List<List<Integer>> getPickedLotteries() {
        return pickedLotteries;
    }
}
