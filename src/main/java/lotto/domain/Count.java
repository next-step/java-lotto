package lotto.domain;

public class Count {

    private static final String NUMBER_PATTERN = "\\d+";
    private static final String NOT_NUMERIC_EXCEPTION_MESSAGE = "숫자만 입력할 수 있습니다.";
    private static final String NOT_POSITIVE_EXCEPTION_MESSAGE = "0 이상의 수만 입력하실 수 있습니다.";
    private static final String NOT_ENOUGH_MONEY_EXCEPTION_MESSAGE = "구매 가능 개수를 초과하였습니다.";

    private final int value;

    public Count(final int value) {
        this(String.valueOf(value));
    }

    public Count(final String value) {
        validateNumeric(value);
        validatePositive(Integer.parseInt(value));

        this.value = Integer.parseInt(value);
    }

    public Count(final String value, final Money money) {
        validateNumeric(value);
        validatePositive(Integer.parseInt(value));
        validateEnoughMoney(value, money);

        this.value = Integer.parseInt(value);
    }

    private void validateNumeric(final String value) {
        if (!value.matches(NUMBER_PATTERN)) {
            throw new IllegalArgumentException(NOT_NUMERIC_EXCEPTION_MESSAGE);
        }
    }

    private void validatePositive(final int value) {
        if (value < 0) {
            throw new IllegalArgumentException(NOT_POSITIVE_EXCEPTION_MESSAGE);
        }
    }

    private void validateEnoughMoney(final String value, final Money money) {
        if (Integer.parseInt(value) * Lotto.PRICE > money.getValue()) {
            throw new IllegalArgumentException(NOT_ENOUGH_MONEY_EXCEPTION_MESSAGE);
        }
    }

    public int getValue() {
        return value;
    }
}
