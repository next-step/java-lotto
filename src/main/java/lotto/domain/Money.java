package lotto.domain;

public class Money {

    private static final int MIN_PURCHASE_MONEY = 1_000;
    private static final int MAX_PURCHASE_MONEY = 100_000;
    private static final String MONEY_RANGE_EXCEPTION_MESSAGE =
            "로또는 " + MIN_PURCHASE_MONEY + "원 이상 " + MAX_PURCHASE_MONEY + "원 이하만 구매할 수 있습니다";
    private static final String NUMBER_PATTERN = "\\d+";
    private static final String NOT_NUMERIC_EXCEPTION_MESSAGE = "숫자만 입력할 수 있습니다.";
    private static final String MONEY_LOWER_THAN_ZERO_EXCEPTION_MESSAGE = "돈은 0보다 작아질 수 없습니다.";

    private final int value;

    Money(final int value) {
        this.value = value;
    }

    public Money(final String value) {
        validate(value);
        this.value = Integer.parseInt(value);
    }

    private void validate(final String value) {
        validateNumericPattern(value);
        validateRangeOfMoney(Integer.parseInt(value));
    }

    private void validateNumericPattern(final String value) {
        if (!value.matches(NUMBER_PATTERN)) {
            throw new IllegalArgumentException(NOT_NUMERIC_EXCEPTION_MESSAGE);
        }
    }

    private void validateRangeOfMoney(final int money) {
        if (money < MIN_PURCHASE_MONEY || MAX_PURCHASE_MONEY < money) {
            throw new IllegalArgumentException(MONEY_RANGE_EXCEPTION_MESSAGE);
        }
    }

    public Money minus(final Money money) {
        validateLowerThanZero(this.value - money.getValue());
        return new Money(this.value - money.getValue());
    }

    private void validateLowerThanZero(final int money) {
        if (money < 0) {
            throw new IllegalArgumentException(MONEY_LOWER_THAN_ZERO_EXCEPTION_MESSAGE);
        }
    }

    public int getValue() {
        return this.value;
    }
}
