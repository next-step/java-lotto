package calculator;

import java.util.Objects;

public class Number {

    public static final Number ZERO_NUMBER = new Number(0);

    private final int number;

    public Number(String number) {
        this(Integer.parseInt(number));
    }

    public Number(int number) {
        this.number = number;
    }

    public Number add(Number operand) {
        return new Number(this.number + operand.number);
    }

    public boolean isNegative() {
        return number < 0;
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
