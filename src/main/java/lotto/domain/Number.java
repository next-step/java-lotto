package lotto.domain;

import java.util.Objects;

public class Number extends ExpressionElement {

    private final int number;

    public Number(int number) {
        this.number = number;
    }

    public int get() {
        return this.number;
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
