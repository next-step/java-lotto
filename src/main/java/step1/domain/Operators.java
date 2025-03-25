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

    public int size() {
        return operators.size();
    }

    public Operator get(int index) {
        return operators.get(index);
    }
}
