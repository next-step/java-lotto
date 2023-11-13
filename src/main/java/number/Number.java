package number;

import java.util.Objects;

public class Number {

    private final int number;

    private Number(int number) {
        this.number = number;
    }

    public static Number from(String text) {
        System.out.println("text = " + text);
        if (!positiveNumber(text)) {
            throw new IllegalArgumentException("양수가 아닙니다. : " + text);
        }
        return new Number(Integer.parseInt(text));
    }

    private static boolean positiveNumber(String text) {
        return isNumber(text) && positive(Integer.parseInt(text));
    }

    private static boolean positive(int num) {
        return num > 0;
    }

    private static boolean isNumber(String text) {
        try {
            Integer.parseInt(text);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public int value() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number1 = (Number) o;
        return number == number1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}