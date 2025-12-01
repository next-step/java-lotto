package domain;

import java.util.Objects;

public class Operand {
    private Number first;
    private Number second;

    public Operand(int first, int second) {
        this(new Number(first), new Number(second));
    }

    public Operand(Number first, Number second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Operand operand = (Operand) o;
        return Objects.equals(first, operand.first) && Objects.equals(second, operand.second);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }
}
