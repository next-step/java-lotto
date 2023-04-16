package stringcalculator;

import java.security.InvalidParameterException;
import java.util.Objects;

public class Number {

    public static final Operator DIVISION = new Operator("/");

    private int value;

    public Number(String value) {
        this.value = toInt(validValue(value));
    }

    public Number(int value) {
        this.value = value;
    }

    private String validValue(String value) {
        if (isValid(value)) {
            throw new InvalidParameterException("빈 숫자는 입력할 수 없습니다.");
        }
        return value;
    }

    private int toInt(String number) {
        return Integer.parseInt(number);
    }

    private boolean isValid(String number) {
        return number == null || number.isBlank();
    }

    public Number clone() {
        return new Number(value);
    }

    public int value() {
        return value;
    }

    public Number calculation(Operator operator, Number number) {
        if (isInvalidDivision(operator, number)) {
            throw new InvalidParameterException("나누어 떨어지지 않는 수로는 나눌수 없습니다.");
        }
        return operator.operation().calculation(this, number);
    }

    private boolean isInvalidDivision(Operator operator, Number number) {
        return isDivision(operator) && isInDivisible(number);
    }

    private boolean isDivision(Operator operator) {
        return operator.equals(DIVISION);
    }

    private boolean isInDivisible(Number number) {
        return this.value % number.value() != 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Number number1 = (Number) o;
        return value == number1.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

}
