package calculator.model;

import java.util.List;

public class Operators {
    private final List<Operator> operators;

    public Operators(List<Operator> operators) {
        this.operators = operators;
    }

    public int size() {
        return operators.size();
    }

    public Number operate(int index, Number left, Number right) {
        return operators.get(index).calculate(left, right);
    }
}
