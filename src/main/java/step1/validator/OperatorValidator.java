package step1.validator;

import step1.calculator.Operation;
import step1.util.CountUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OperatorValidator implements ExpressionCount {
    private static final Pattern OPERATOR_PATTERN = Pattern.compile("[^\\d\\s]+");

    public OperatorValidator() {
    }

    public int countByExpression(String input) {
        assertNullOrBlank(input);
        assertOperator(input);

        return CountUtil.countByExpression(input, OPERATOR_PATTERN);
    }

    private void assertNullOrBlank(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("빈 문자열은 허용하지 않습니다");
        }
    }

    private void assertOperator(String input) {
        Matcher matcher = OPERATOR_PATTERN.matcher(input);

        while (matcher.find()) {
            String operator = matcher.group();
            Operation.find(operator);
        }
    }
}
