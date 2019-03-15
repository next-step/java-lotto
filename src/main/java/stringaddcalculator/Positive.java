package stringaddcalculator;

import java.util.Objects;

public class Positive {
    private int number;

    public Positive(int number) {
        if (number < 0)
            throw new IllegalArgumentException();
        this.number = number;
    }

    public Positive add(Positive positive) {
        this.number += positive.number;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Positive positive = (Positive) o;
        return number == positive.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
