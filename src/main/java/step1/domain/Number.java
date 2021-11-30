package step1.domain;

import step1.exception.DelimiterFormatException;

import java.util.Objects;

public class Number {
    private final int number;

    private Number(int number) {
        this.number = number;
    }

    public static Number createFromInt(int number) {
        validateNumbers(number);
        return new Number(number);
    }

    public static Number createFromString(String number) {
        try {
            return new Number(Integer.parseInt(number));
        } catch (NumberFormatException e) {
            throw new DelimiterFormatException("숫자 사이의 구분자 오류");
        }
    }

    public int getNumber() {
        return number;
    }

    private static void validateNumbers(int number) {
        if (number > 0) {
            return;
        }

        throw new RuntimeException("입력 숫자 오류");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number that = (Number) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
