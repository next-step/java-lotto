package calculator.domain;

import java.util.Objects;
import java.util.regex.Pattern;

public class Operand {

    private static final Pattern POSITIVE_INTEGER_PATTERN = Pattern.compile("\\d+");

    public static final Operand ZERO = new Operand(0);

    private int value;

    private Operand(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Operand from(String value) {
        verify(value);
        return new Operand(Integer.parseInt(value));
    }

    private static void verify(String value) {
        if (isNullOrEmpty(value)) {
            throw new IllegalArgumentException("null 또는 빈문자열을 피연산자로 사용할 수 없습니다.");
        }

        if (!isPositiveInteger(value)) {
            throw new IllegalArgumentException("양의 정수만 피연산자로 사용할 수 있습니다.");
        }
    }

    private static boolean isNullOrEmpty(String value) {
        return Objects.isNull(value) || value.isEmpty();
    }

    private static boolean isPositiveInteger(String value) {
        return POSITIVE_INTEGER_PATTERN.matcher(value).matches();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operand operand = (Operand) o;
        return value == operand.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
