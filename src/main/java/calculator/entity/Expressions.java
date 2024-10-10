package calculator.entity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Expressions {

    private final List<CalculateExpression> expressions;

    public Expressions() {
        expressions = Arrays.asList(
                CalculateExpression.ADD,
                CalculateExpression.SUBTRACT,
                CalculateExpression.MULTIPLY,
                CalculateExpression.DIVIDE
        );
    }

    public CalculateExpression findExpression(String expression) {
        return this.expressions.stream().filter(i -> i.isMatch(expression)).findFirst().orElseThrow(() -> new IllegalArgumentException("존재하지 않는 부호"));
    }

}
