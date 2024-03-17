package lotto.domain;

import java.util.Objects;

public class Operator extends ExpressionElement {

    private final String operator;

    public Operator(String operator) {
        this.operator = operator;
    }

    public String get() {
        return this.operator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operator operator1 = (Operator) o;
        return Objects.equals(operator, operator1.operator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operator);
    }
}
