package lotto.domain;

public class Money {

    public static final Integer LOTTO_UNIT_PRICE = 1_000;
    public static final int ZERO = 0;

    private final Integer amount;

    private Money(Integer amount) {
        this.amount = amount;
    }

    public static Money initMoney(int amount) {
        if (isNegativeNumberOrZero(amount)) {
            throw new IllegalArgumentException("0보다 큰 수를 입력해주세요.");
        }
        return new Money(amount);
    }

    private static boolean isNegativeNumberOrZero(int amount) {
        return amount <= ZERO;
    }

    public int getLottoQuantity() {
        return amount / LOTTO_UNIT_PRICE;
    }
}
