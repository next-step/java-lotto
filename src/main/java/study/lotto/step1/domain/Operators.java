package study.lotto.step1.domain;

import java.util.List;

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
}
