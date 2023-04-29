package study.lotto.step1.domain;

import java.util.List;
import java.util.Objects;

public class Operators {
    private static final int FIRST_INDEX = 0;
    private final List<Operator> operators;

    public Operators(List<Operator> operators) {
        this.operators = operators;
    }

    public boolean hasNext() {
        return !operators.isEmpty();
    }

    public Operator removeFirst() {
        return operators.remove(FIRST_INDEX);
    }

    public int size() {
        return operators.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Operators)) return false;
        Operators operators1 = (Operators) o;
        return Objects.equals(operators, operators1.operators);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operators);
    }
}
