package lotto.domain;

public class LottoMoney implements Comparable<LottoMoney> {

    private final int amount;

    private LottoMoney(int amount) {
        this.amount = amount;
    }

    public static LottoMoney of(int purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        return new LottoMoney(purchaseAmount);
    }

    public static LottoMoney fromCount(int purchaseCount) {
        validatePurchaseCount(purchaseCount);
        return new LottoMoney(purchaseCount * LottoTicket.PRICE);
    }

    private static void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount < LottoTicket.PRICE) {
            throw new IllegalArgumentException("금액이 부족합니다. 최소 " + LottoTicket.PRICE + " 원 이상의 금액을 입력해 주세요.");
        }
    }

    private static void validatePurchaseCount(int purchaseCount) {
        if (purchaseCount <= 0) {
            throw new IllegalArgumentException("구매 수량을 입력해 주세요.");
        }
    }

    public int purchaseCount() {
        return amount / LottoTicket.PRICE;
    }

    @Override
    public int compareTo(LottoMoney o) {
        return Integer.compare(this.amount, o.amount);
    }
}
