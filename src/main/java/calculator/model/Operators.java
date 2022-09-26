package calculator.model;

import java.util.Stack;

public class Operators {

    private final Stack<Operator> operators;

    public Operators() {
        this.operators = new Stack<>();
    }

    public void add(Operator operator) {
        if (!this.operators.isEmpty()) {
            throw new IllegalArgumentException("invalid operator number");
        }
        this.operators.push(operator);
    }

    public Operator getOperator() {
        if (this.operators.isEmpty()) {
            throw new IllegalArgumentException("invalid operator number");
        }
        return this.operators.pop();
    }
}
