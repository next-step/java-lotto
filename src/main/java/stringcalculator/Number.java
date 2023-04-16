package stringcalculator;

import java.security.InvalidParameterException;
import java.util.Objects;

public class Number {

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
