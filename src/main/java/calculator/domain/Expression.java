package calculator.domain;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Expression {

    private final Queue<Number> numbers;
    private final Queue<Operator> operators;

    public Expression(List<ExpressionElement> elements) {
        this.numbers = new LinkedList<>();
        this.operators = new LinkedList<>();
        enqueue(elements);
    }

    private void enqueue(List<ExpressionElement> elements) {
        for (ExpressionElement element : elements) {
            addNumberOrOperator(element);
        }

    }

    private void addNumberOrOperator(ExpressionElement element) {
        if (element instanceof Number) {
            this.numbers.add((Number) element);
        }
        if (element instanceof Operator) {
            this.operators.add((Operator) element);
        }
    }

    public Queue<Number> getNumbers() {
        return this.numbers;
    }

    public Queue<Operator> getOperators() {
        return this.operators;
    }

    public Number getNumber() {
        return this.numbers.poll();
    }

    public Operator getOperator() {
        return this.operators.poll();
    }

    public boolean hasOperator() {
        return !this.operators.isEmpty();
    }

}
