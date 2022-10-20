package step1.arithmeticExpression.numbers;

import java.util.List;
import java.util.Objects;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ExpressionAsNumbers {

    private static final Pattern NUMBERS_EXTRACTION_RULE = Pattern.compile("-?\\d+");

    private final String expression;

    public ExpressionAsNumbers(String expression) {
        this.expression = expression;
    }

    public List<Integer> numbers() {
        verifyValidExpression();

        return NUMBERS_EXTRACTION_RULE.matcher(expression)
                .results()
                .map(MatchResult::group)
                .map(Integer::parseInt)
                .collect(Collectors.toUnmodifiableList());
    }

    private void verifyValidExpression() {
        if (expression == null || expression.equals("")) {
            throw new IllegalStateException("올바른 연산식이 아닙니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExpressionAsNumbers that = (ExpressionAsNumbers) o;
        return Objects.equals(expression, that.expression);
    }

    @Override
    public int hashCode() {
        return Objects.hash(expression);
    }
}
