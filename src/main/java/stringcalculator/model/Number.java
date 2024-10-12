package stringcalculator.model;

import java.util.Objects;
import java.util.regex.Pattern;

public class Number {

    private static final Pattern UniqueNumberPattern = Pattern.compile("^\\d+$");
    private static final String UNIQUE_NUMBER_ERROR_MESSAGE = "숫자는 정수를 입력해주세요!";
    private int number;

    public Number(int number) {
        this.number = number;
    }

    public Number(String number) {
        validationNumber(number);
        this.number = Integer.parseInt(number);
    }

    private void validationNumber(String number) {
        if (!UniqueNumberPattern.matcher(number).matches()) {
            throw new IllegalArgumentException(UNIQUE_NUMBER_ERROR_MESSAGE);
        }
    }

    public int getNumber() {
        return this.number;
    }

    public boolean isZero() {
        return this.number == 0;
    }

    @Override
    public String toString() {
        return String.valueOf(this.number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Number)) return false;
        Number number1 = (Number) o;
        return number == number1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(number);
    }
}
