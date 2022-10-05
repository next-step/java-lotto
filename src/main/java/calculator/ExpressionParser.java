package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ExpressionParser {

    private static final Pattern EXPRESSION_PATTERN = Pattern.compile("[\\d */+-]+");
    private String[] tokens;

    public ExpressionParser(String expression) {
        valid(expression);
        tokens = expression.split(" ");
    }

    private void valid(String expression) {
        if (expression == null || expression.isEmpty()) {
            throw new IllegalArgumentException("입력 값이 null 이나 공백은 불가능합니다.");
        }

        if (!EXPRESSION_PATTERN.matcher(expression).matches()) {
            throw new IllegalArgumentException("입력 값에 올바르지 않은 문자열이 포함되어 있습니다.");
        }
    }

    public List<Operator> getOperators() {
        return Arrays.stream(tokens)
                .filter(Operator::isOperator)
                .map(Operator::from)
                .collect(Collectors.toList());
    }

    public List<Operand> getOperands() {
        return Arrays.stream(tokens)
                .filter(Operand::isOperand)
                .map(Operand::from)
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExpressionParser that = (ExpressionParser) o;
        return Arrays.equals(tokens, that.tokens);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(tokens);
    }
}
