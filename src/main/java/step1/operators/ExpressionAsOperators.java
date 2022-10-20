package step1.operators;

import step1.Operator;

import java.util.ArrayDeque;
import java.util.List;
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

}
