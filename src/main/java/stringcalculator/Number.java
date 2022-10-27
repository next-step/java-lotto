package stringcalculator;

import java.util.Objects;

public class Number {
    private final int value;

    public Number(int value) {
        this.value = value;
    }

    public static Number valueOf(String number) {
        try {
            validateNullOrEmpty(number);
            return new Number(Integer.parseInt(number));
        } catch (NumberFormatException nfe) {
            throw new CaculateException(ErrorCode.WRONG_NUMBER_FORMAT);
        }
    }

    private static void validateNullOrEmpty(String number) {
        if (Objects.isNull(number) || number.isEmpty()) {
            throw new CaculateException(ErrorCode.NUMBER_IS_NULL);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number1 = (Number) o;
        return value == number1.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public Number plus(Number number) {
        return new Number(this.value + number.value);
    }

    public Number subtract(Number number) {
        return new Number(this.value - number.value);
    }

    public Number multiply(Number number) {
        return new Number(this.value * number.value);
    }

    public Number divide(Number number) {
        if (number.value == 0) {
            throw new CaculateException(ErrorCode.DIVIDE_WITH_ZERO);
        }

        if (this.value % number.value != 0) {
            throw new CaculateException(ErrorCode.EXIST_REMAINDER);
        }

        return new Number(this.value / number.value);
    }
}
