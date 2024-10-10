package calculator.entity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Expressions {

    private final List<Expression> expressions;

    public Expressions() {
        expressions = Arrays.asList(
                new Expression(CalculateExpression.ADD),
                new Expression(CalculateExpression.SUBTRACT),
                new Expression(CalculateExpression.MULTIPLY),
                new Expression(CalculateExpression.DIVIDE)
        );
    }

    public Expression findExpression(String expression) {
        Optional<Expression> optionalExpression = expressions.stream().filter(i -> i.isMatch(expression)).findFirst();
        return validate(optionalExpression);
    }

    private Expression validate(Optional<Expression> optionalExpression) {
        if (optionalExpression.isEmpty()) {
            throw new IllegalArgumentException("존재하지 않는 부호");
        }
        return optionalExpression.get();
    }
}
