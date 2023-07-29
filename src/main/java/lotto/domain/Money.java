package lotto.domain;

public class Money {

    private static final int MIN_PURCHASE_MONEY = 1_000;
    private static final int MAX_PURCHASE_MONEY = 100_000;
    private static final String MONEY_RANGE_EXCEPTION_MESSAGE =
            "로또는 " + MIN_PURCHASE_MONEY + "원 이상 " + MAX_PURCHASE_MONEY + "원 이하만 구매할 수 있습니다";
    private static final String NUMBER_PATTERN = "\\d+";
    private static final String NOT_NUMERIC_EXCEPTION_MESSAGE = "숫자만 입력할 수 있습니다.";

    private final int value;

    public Money(final int value) {
        this(String.valueOf(value));
    }

    public Money(final String value) {
        validate(value);
        this.value = Integer.parseInt(value);
    }

    private void validate(final String value) {
        validateNumeric(value);
        validateRangeOfMoney(value);
    }

    private void validateNumeric(final String value) {
        if (!value.matches(NUMBER_PATTERN)) {
            throw new IllegalArgumentException(NOT_NUMERIC_EXCEPTION_MESSAGE);
        }
    }

    private void validateRangeOfMoney(final String value) {
        int money = Integer.parseInt(value);

        if (money < MIN_PURCHASE_MONEY || MAX_PURCHASE_MONEY < money) {
            throw new IllegalArgumentException(MONEY_RANGE_EXCEPTION_MESSAGE);
        }
    }

    public Money subtract(final Money other) {
        return new Money(String.valueOf(value - other.getValue()));
    }

    public int getValue() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Money money = (Money) o;

        return value == money.value;
    }

    @Override
    public int hashCode() {
        return value;
    }
}
