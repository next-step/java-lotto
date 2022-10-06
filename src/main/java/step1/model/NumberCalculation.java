package step1.model;

import java.util.Objects;

public class NumberCalculation {

    private int number;

    public NumberCalculation(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void sum(final int number) {
        this.number += number;
    }

    public void subtract(int number) {
        this.number -= number;
    }

    public void multiply(int number) {
        this.number *= number;
    }

    public void divided(int number) {
        this.number /= number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NumberCalculation that = (NumberCalculation) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
