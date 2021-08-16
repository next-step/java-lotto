package lotto.domain;

public class PurchaseAmount {

    private static final int PURCHASE_AMOUNT_UNIT = 1000;
    private static final int ZERO_CASH = 0;
    private int cash;

    public PurchaseAmount(int cash) {
        validateCash(cash);
        this.cash = cash;
    }

    public int purchases() {
        return cash / PURCHASE_AMOUNT_UNIT;
    }

    public int cash() {
        return this.cash;
    }

    private void validateCash(int cash) {

        if (cash < PURCHASE_AMOUNT_UNIT) {
            throw new IllegalArgumentException("최소 구매 금액이 1000원 입니다.(1장당 1000원)");
        }

        if ((cash % PURCHASE_AMOUNT_UNIT) > ZERO_CASH) {
            throw new IllegalArgumentException("구매금액은 1000원 단위 입니다.");
        }

    }

}
