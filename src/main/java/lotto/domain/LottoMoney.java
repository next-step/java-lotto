package lotto.domain;

public class LottoMoney {

    private final int amount;

    private LottoMoney(int amount) {
        this.amount = amount;
    }

    public static LottoMoney of(int purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        return new LottoMoney(purchaseAmount);
    }

    private static void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount < LottoTicket.PRICE) {
            throw new IllegalArgumentException("금액이 부족합니다. 최소 " + LottoTicket.PRICE + " 원 이상의 금액을 입력해 주세요.");
        }
    }

    public int amount() {
        return amount;
    }

    public int purchaseCount() {
        return amount / LottoTicket.PRICE;
    }
}
