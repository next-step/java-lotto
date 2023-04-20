package lotto.domain;

public class Money {

    public static final Integer LOTTO_UNIT_PRICE = 1_000;

    private final Integer amount;

    private Money(Integer amount) {
        this.amount = amount;
    }

    public static Money initMoney(int amount) {
        return new Money(amount);
    }

    public int getLottoQuantity() {
        return amount / LOTTO_UNIT_PRICE;
    }
}
