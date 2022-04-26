package calculator.domain;

import calculator.domain.operation.Operation;

import java.util.Objects;

public class Number {

    private static final int INITIAL_NUMBER = 0;
    private int number;

    public Number() {
        this(INITIAL_NUMBER);
    }

    public Number(String value) {
        this(Integer.parseInt(value));
    }

    public Number(int number) {
        this.number = number;
    }

    public void calculate(Operation operation, Number number) {
        this.number = operation.operate(this.number, number.number);
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
        return String.valueOf(this.number);
    }

    public int toInt() {
        return this.number;
    }
}
