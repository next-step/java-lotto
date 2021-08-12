package lotto.domain;

public class PurchaseAmount {

    private int cash;

    public PurchaseAmount(int cash) {
        validateCash(cash);
        this.cash = cash;
    }

    public int purchases() {
        return cash / 1000;
    }

    public int cash() {
        return this.cash;
    }

    private void validateCash(int cash) {

        if (cash < 1000) {
            throw new IllegalArgumentException("최소 구매 금액이 1000원 입니다.(1장당 1000원)");
        }

        if ((cash % 1000) > 0) {
            throw new IllegalArgumentException("구매금액은 1000원 단위 입니다.");
        }

    }

}
