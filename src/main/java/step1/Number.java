package step1;

import java.util.Objects;

public class Number {
    private final int number;

    public Number(String text) {
        minusCheck(text);
        this.number = Integer.parseInt(text);
    }

    public int valueOf() {
        return this.number;
    }

    public void minusCheck(String number) {
        if (Integer.parseInt(number) < 0) {
            throw new RuntimeException(ErrorMessage.NOT_MINUS_NUMBER);
        }
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
