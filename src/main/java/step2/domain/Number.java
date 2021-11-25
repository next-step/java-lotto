package step2.domain;

import step2.validator.NumberValidator;

import java.util.Objects;

public class Number {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private int number;

    private Number(int number) {
        validateNumberBound(number);
        this.number = number;
    }

    private Number(String number) {
        int value = Integer.parseInt(number);
        validateNumberBound(value);
        this.number = value;
    }

    public static Number create(int number) {
        return new Number(number);
    }

    public static Number of(String number) {
        NumberValidator.isDigit(number);
        return new Number(number);
    }

    public int getNumber() {
        return number;
    }

    public String getStringNumber() {
        return String.valueOf(number);
    }

    private void validateNumberBound(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException("유효하지 않은 숫자 범위입니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number1 = (Number) o;
        return getNumber() == number1.getNumber();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumber());
    }

    @Override
    public String toString() {
        return "Number{" +
                "number=" + number +
                '}';
    }
}
