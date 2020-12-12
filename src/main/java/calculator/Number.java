package calculator;

import java.util.Objects;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;

public class Number {

    private static final Pattern NUMBER_PATTERN = Pattern.compile("[0-9]+");
    private static final int ZERO = 0;
    private int number;

    public Number(int number) {
        this.number = number;
    }

    public Number(String numberValue) {
        validate(numberValue);
        this.number = convertToInt(numberValue);
    }

    public Number add(Number y) {
        int sum = y.add(this.number);
        return new Number(sum);
    }

    private int add(int number) {
        return this.number + number;
    }

    /**
     * empty or null - pass. (0으로 인식) not a number, number < 0 - throw exception
     */
    private void validate(String numberValue) {
        if (StringUtils.isBlank(numberValue)) {
            return;
        }

        if (!NUMBER_PATTERN.matcher(numberValue).matches()) {
            throwWrongValue();
        }

        if (Integer.parseInt(numberValue) < ZERO) {
            throwWrongValue();
        }
    }

    private int convertToInt(String numberValue) {
        if (StringUtils.isBlank(numberValue)) {
            return ZERO;
        }

        return Integer.parseInt(numberValue);
    }

    private int throwWrongValue() {
        throw new IllegalArgumentException("0 이상 숫자를 입력해주세요");
    }

    public int getNumber() {
        return number;
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
        return number == number1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}