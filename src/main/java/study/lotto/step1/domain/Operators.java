package study.lotto.step1.domain;

import java.util.Deque;

public class Operators {
    private final Deque<Operator> operators;

    public Operators(Deque<Operator> operators) {
        this.operators = operators;
    }

    public boolean hasNext() {
        return !operators.isEmpty();
    }

    public Operator removeFirst() {
        return operators.removeFirst();
    }
}
