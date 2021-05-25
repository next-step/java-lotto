package lotto.domain;

public class Money {

    private static final String MONEY_POSITIVE = "금액은 0보다 큰 정수를 입력해주세요.";
    private static final String MONEY_UNIT_1000 = "금액은 1,000원 단위로 입력해주세요.";
    private static final int ZERO = 0;

    public static final int LOTTO_PRICE = 1000;

    private final int amount;

    public Money(int amount) {
        validatePositive(amount);
        validateUnit(amount);
        this.amount = amount;
    }

    public static Money of(int amount) {
        return new Money(amount);
    }

    public static Money ofLottoCount(int count) {
        return new Money(count * LOTTO_PRICE);
    }

    public int getBuyableLottoSize() {
        return amount / LOTTO_PRICE;
    }

    public int value() {
        return amount;
    }

    public Money minus(Money money) {
        return new Money(this.amount - money.value());
    }

    private void validatePositive(int amount) {
        if (amount <= ZERO) {
            throw new IllegalArgumentException(MONEY_POSITIVE);
        }
    }

    private void validateUnit(int amount) {
        if (amount % LOTTO_PRICE != ZERO) {
            throw new IllegalArgumentException(MONEY_UNIT_1000);
        }
    }
}
