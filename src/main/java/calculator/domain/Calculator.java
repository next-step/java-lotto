package calculator.domain;

import java.util.Objects;

public class Calculator {
    private final int i;
    private final int j;

    public Calculator(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public int add() {
        return i + j;
    }

    public int subtract() {
        return i - j;
    }

    public int multiply() {
        return i * j;
    }

    public int divide() {
        return i / j;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Calculator that = (Calculator) o;
        return i == that.i && j == that.j;
    }

    @Override
    public int hashCode() {
        return Objects.hash(i, j);
    }
}
