package step4.domain;

public class Money {

        private final int money;

    public Money(int money) {
        this.money = money;
    }

    public int calculateLottoPurchaseCount() {
        return money / LottoConfig.UNIT_PRICE;
    }

}
