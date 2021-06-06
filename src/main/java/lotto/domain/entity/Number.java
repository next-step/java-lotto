package lotto.domain.entity;

import lotto.domain.config.NumberSize;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class Number implements Comparable<Number> {

    private final int number;
    private static Map<Integer, Number> numbers = new HashMap<>();

    static {
        for (int i = NumberSize.NUMBER_MIN; i <= NumberSize.NUMBER_MAX; i++) {
            numbers.put(i, new Number(i));
        }
    }

    private Number(int number) {
        this.number = number;
    }

    public static Number of(int number) {
        validate(number);
        return numbers.get(number);
    }

    public static Number of(String text) {
        validateStringToNumber(text);
        return of(Integer.parseInt(text));
    }

    private static void validateStringToNumber(String text) {
        String numberPattern = "[+-]?\\d*(\\.\\d+)?";
        if (!text.matches(numberPattern)) {
            throw new NumberFormatException("숫자만 입력 가능합니다.");
        }
    }

    private static void validate(int number) {
        if (numbers.get(number) == null) {
            throw new IllegalArgumentException("로또 숫자 범위는 1 ~ 45 사이입니다.");
        }
    }

    public int getNumber() {
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

    @Override
    public String toString() {
        return "Number{" +
                "number=" + number +
                '}';
    }

    @Override
    public int compareTo(Number number) {
        return getNumber() - number.getNumber();
    }
}
