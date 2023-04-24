package lotto.domain;

public class Money {

    private static final Integer LOTTO_UNIT_PRICE = 1_000;

    private final Integer amount;

    private Money(Integer amount) {
        if (isNegativeNumberOrZero(amount)) {
            throw new IllegalArgumentException("1000원 이상 입력해주세요.");
        }
        this.amount = amount;
    }

    public static Money initMoney(int amount) {
        return new Money(amount);
    }

    private static boolean isNegativeNumberOrZero(int amount) {
        return amount <= LOTTO_UNIT_PRICE;
    }

    public int getLottoQuantity() {
        return amount / LOTTO_UNIT_PRICE;
    }

    public int getAmount() {
        return amount;
    }
}
