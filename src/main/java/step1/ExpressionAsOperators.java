package step1;

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
        List<Operator> operators = OPERATORS_EXTRACTION_RULE.matcher(expression)
                .results()
                .map(MatchResult::group)
                .map(Operator::foundOperator)
                .collect(Collectors.toUnmodifiableList());

        return new ArrayDeque<>(operators);
    }

}
