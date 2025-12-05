package calculator.domain;

import java.util.Objects;

public class Number {
    private final int number;

    public Number(String number) {
        this(Integer.parseInt(number));
    }

    public Number(int number) {
        this.number = number;
    }

    public Number calculate(Operator operator, Number otherNumber) {
        return operator.operate(this, otherNumber);
    }

    public Number plus(Number other) {
        return new Number(this.number + other.number);
    }

    public Number substract(Number other) {
        return new Number(this.number - other.number);
    }

    public Number multiply(Number other) {
        return new Number(this.number * other.number);
    }

    public Number divide(Number other) {
        return new Number(this.number / other.number);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Number number1 = (Number) o;
        return number == number1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(number);
    }


    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
