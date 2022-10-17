package calculator.domain;

import calculator.utils.StringUtils;

public class NumberValue {

    private final int value;

    public NumberValue(final int value) {
        this(Integer.toString(value));
    }

    public NumberValue(final String value) {
        validateNumber(value);
        this.value = Integer.parseInt(value);
    }

    private static void validateNumber(final String number) {
        if (StringUtils.isEmpty(number)) {
            throw new IllegalArgumentException("숫자는 빈 값일 수 없습니다.");
        }
    }

    public NumberValue plus(final NumberValue numberValue) {
        return new NumberValue(this.value + numberValue.value);
    }

    public NumberValue minus(final NumberValue numberValue) {
        return new NumberValue(this.value - numberValue.value);
    }

    public NumberValue times(final NumberValue numberValue) {
        return new NumberValue(this.value * numberValue.value);
    }

    public NumberValue divide(final NumberValue numberValue) {
        if (numberValue.value == 0) {
            throw new ArithmeticException("0으로 나눌 수 없습니다.");
        }

        if (this.value % numberValue.value != 0) {
            throw new ArithmeticException("나눗셈 결과가 정수로 나누어 떨어지지 않습니다.");
        }

        return new NumberValue(this.value / numberValue.value);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof NumberValue)) return false;

        NumberValue numberValue = (NumberValue) o;

        return value == numberValue.value;
    }

    @Override
    public int hashCode() {
        return value;
    }

    public int getValue() {
        return value;
    }
}
