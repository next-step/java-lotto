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
        validate(money, pickedLotteries);
        this.money = money;
        this.pickedLotteries = pickedLotteries;
    }

    private void validate(int money, List<List<Integer>> pickedLotteries) {
        if (money / BASE_MONEY < pickedLotteries.size()) {
            throw new IllegalArgumentException("구입금액보다 큰 수동로또 숫자 입력은 불가능합니다.");
        }
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
