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
        if (purchaseAmount < 0) {
            throw new IllegalArgumentException("금액은 음수가 될 수 없습니다.");
        }
    }

    private static void validatePurchaseCount(int purchaseCount) {
        if (purchaseCount < 0) {
            throw new IllegalArgumentException("구매 수량을 입력해 주세요.");
        }
    }

    public void validatePurchasable() {
        if (amount < LottoTicket.PRICE) {
            throw new IllegalStateException("금액이 부족합니다. 최소 " + LottoTicket.PRICE + " 원 이상의 금액을 입력해 주세요.");
        }
    }

    public int purchaseCount() {
        return amount / LottoTicket.PRICE;
    }

    @Override
    public int compareTo(LottoMoney arg) {
        return Integer.compare(this.amount, arg.amount);
    }

    public LottoMoney subtract(LottoMoney arg) {
        validateSubtracts(arg);
        return LottoMoney.of(amount - arg.amount);
    }

    private void validateSubtracts(LottoMoney arg) {
        if (this.compareTo(arg) < 0) {
            throw new IllegalArgumentException("금액은 음수가 될 수 없습니다. 감수를 확인해 주세요.");
        }
    }
}
