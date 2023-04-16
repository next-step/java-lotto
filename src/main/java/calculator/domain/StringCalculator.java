package calculator.domain;

import java.util.List;
import java.util.Queue;

public class StringCalculator {

    private final Expression expression;

    public StringCalculator(Expression expression) {
        this.expression = expression;
    }

    public int calculate() {
        Queue<String> operators = expression.getOperators();
        List<Integer> operands = expression.getOperands();

        return operands.stream()
                .reduce((acc, curr) -> Operator.calculate(operators.poll(), acc, curr))
                .get();
    }

}
