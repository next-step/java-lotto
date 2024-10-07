package lotto.domain;

public class Money {
    public static final int LOTTO_PURCHASE_AMOUNT = 1000;

    private int money;

    public Money(final int money) {
        if (LOTTO_PURCHASE_AMOUNT > money) {
            throw new IllegalArgumentException(LOTTO_PURCHASE_AMOUNT + "이상의 금액을 입력해주세요.");
        }

        this.money = money;
    }
}
