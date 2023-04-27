package calculator.domain.expression;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class Operators {
    private final Queue<Operator> operators;

    public Operators(Queue<Operator> operators) {
        this.operators = operators;
    }

    public Operators(Operators original) {
        this.operators = new LinkedList<>(original.operators);
    }

    public static Operators extractOperator(List<String> expression) {
        Queue<Operator> operators = expression.stream()
                .filter(Operator::isOperator)
                .map(Operator::of)
                .collect(Collectors.toCollection(LinkedList::new));
        return new Operators(operators);
    }

    public Operator next() {
        return operators.poll();
    }

    public int getNumberOfOperators() {
        return operators.size();
    }

    public boolean isInValid() {
        return operators.isEmpty();
    }

    public boolean hasInValidSizeWithOperands(Operands operands) {
        return operators.size() != operands.getNumberOfOperands() - 1;
    }
}
