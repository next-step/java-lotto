package step1.domain;

import java.util.Objects;

public class Number {

    private final int number;

    public Number(int number) {
        this.number = number;
    }

    public Number(String input) {
        this(Integer.parseInt(input));
    }

    public int value() {
        return number;
    }

    Number plus(Number number) {
        return new Number(this.number + number.number);
    }

    Number minus(Number number) {
        return new Number(this.number - number.number);
    }

    Number multiple(Number number) {
        return new Number(this.number * number.number);
    }

    Number divide(Number number) {
        return new Number(this.number / number.number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
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
}
