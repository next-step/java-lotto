package step1.domain;

import java.util.List;

public class Operators {
    private final List<Operator> operators;

    public Operators(List<Operator> operators) {
        this.operators = operators;
    }

    public List<Operator> getOperators() {
        return List.copyOf(operators);
    }
}
