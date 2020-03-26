package calculate.domain;

import java.util.Objects;

public class Operand {
    private int i;

    public Operand(int i) {
        this.i = i;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operand operand = (Operand) o;
        return i == operand.i;
    }

    @Override
    public int hashCode() {
        return Objects.hash(i);
    }
}
