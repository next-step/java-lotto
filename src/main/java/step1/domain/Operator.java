package step1.domain;

import java.util.Objects;

public class Operator {

    private final char operator;

    public Operator(char operator) {
        this.operator = operator;
    }

    public char value() {
        return operator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Operator that = (Operator) o;
        return operator == that.operator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(operator);
    }
}
