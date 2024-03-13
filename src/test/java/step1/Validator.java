package step1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    private static final Pattern OPERAND_PATTERN = Pattern.compile("\\d+");
    private static final Pattern OPERATOR_PATTERN = Pattern.compile("[^\\d\\s]+");
    private static final Pattern START_WITH_NUMBER_PATTERN = Pattern.compile("^\\d");

    public Validator() {
    }

    public void assertValidInput(String input) {
        assertNullOrBlank(input);
        assertStartWithNumber(input);
        assertValidOperator(input);
        assertValidOperation(input);
    }

    private void assertNullOrBlank(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("빈 문자열은 허용하지 않습니다");
        }
    }

    private void assertValidOperator(String input) {
        Matcher matcher = OPERATOR_PATTERN.matcher(input);

        while (matcher.find()) {
            String operator = matcher.group();
            validOperator(operator);
        }
    }

    private void validOperator(String operator) {
        try {
            Operation.find(operator);
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException("유효하지 않은 연산자가 포함되어 있습니다 : " + operator, ex);
        }
    }

    private void assertValidOperation(String input) {
        int operand = countByExpression(input, OPERAND_PATTERN);
        int operator = countByExpression(input, OPERATOR_PATTERN);

        if (invalid(operand, operator)) {
            throw new IllegalArgumentException("유효한 연산식이 아닙니다 : " + input);
        }
    }

    private int countByExpression(String input, Pattern pattern) {
        Matcher matcher = pattern.matcher(input);

        int count = 0;
        while (matcher.find()) {
            count += 1;
        }

        return count;
    }

    private boolean invalid(int operand, int operator) {
        return isSingleNumber(operand, operator) || invalidOperation(operand, operator);
    }

    private boolean isSingleNumber(int operand, int operator) {
        return operand - 1 == 0 && operator == 0;
    }

    private boolean invalidOperation(int operand, int operator) {
        return operand - 1 != operator;
    }

    private void assertStartWithNumber(String input) {
        Matcher matcher = START_WITH_NUMBER_PATTERN.matcher(input);
        if (matcher.find()) {
            return;
        }

        throw new IllegalArgumentException("유효하지 않은 연산식입니다 : " + input);
    }
}
