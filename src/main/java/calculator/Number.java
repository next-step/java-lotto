package calculator;

import java.util.Objects;

public class Number {
    private final int number;

    public Number(String number) {
        try {
            this.number = Integer.parseUnsignedInt(number);
        } catch (NumberFormatException exception) {
            throw new RuntimeException();
        }
    }

    private Number(int number) {
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }

    public Number add(Number number) {
        return new Number(this.number + number.number);
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
