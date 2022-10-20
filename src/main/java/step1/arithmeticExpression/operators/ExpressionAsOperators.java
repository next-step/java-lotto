package step1.arithmeticExpression.operators;

import step1.arithmeticExpression.operators.operator.Operator;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ExpressionAsOperators {

    private static final Pattern OPERATORS_EXTRACTION_RULE = Pattern.compile("[+\\-/*]");

    private final String expression;

    public ExpressionAsOperators(String expression) {
        this.expression = expression;
    }

    public Queue<Operator> operators() {
        verifyValidExpression();

        List<Operator> operators = OPERATORS_EXTRACTION_RULE.matcher(expression)
                .results()
                .map(MatchResult::group)
                .map(Operator::foundOperator)
                .collect(Collectors.toUnmodifiableList());

        return new ArrayDeque<>(operators);
    }

    private void verifyValidExpression() {
        if (expression == null || expression.equals("")) {
            throw new IllegalStateException("올바른 연산식이 아닙니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        verifyValidExpression();

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExpressionAsOperators that = (ExpressionAsOperators) o;
        return Objects.equals(expression, that.expression);
    }

    @Override
    public int hashCode() {
        verifyValidExpression();

        return Objects.hash(expression);
    }
}
