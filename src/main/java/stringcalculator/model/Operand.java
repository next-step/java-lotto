package stringcalculator.model;

import java.util.Objects;

public class Operand {
    public static final String ONLY_ALLOWED_NUMBER = "피연산자에는 숫자 외에 다른 문자가 올 수 없습니다.";
    private final int number;

    public static Operand of(final String number) {
        return new Operand(parseInt(number));
    }

    public Operand(final Integer number) {
        this.number = number;
    }

    private static int parseInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ONLY_ALLOWED_NUMBER);
        }
    }

    public int value() {
        return this.number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operand operand = (Operand) o;
        return number == operand.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
