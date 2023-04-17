package calculator.domain;

import java.util.List;
import java.util.Objects;
import java.util.Queue;

public class StringCalculator {

    private final Expression expression;

    public StringCalculator(Expression expression) {
        this.expression = expression;
    }

    public int calculate() {
        Queue<Operator> operators = expression.getOperators();
        List<Integer> operands = expression.getOperands();

        return operands.stream()
                .reduce((acc, curr) -> Operator.calculate(Objects.requireNonNull(operators.poll()), acc, curr))
                .get();
    }

}
