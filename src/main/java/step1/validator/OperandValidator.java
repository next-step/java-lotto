package step1.validator;

import step1.util.CountUtil;

import java.util.regex.Pattern;

public class OperandValidator implements ExpressionCount {
    private static final Pattern OPERAND_PATTERN = Pattern.compile("\\d+");
    private static final Pattern START_WITH_NUMBER_PATTERN = Pattern.compile("^\\d");

    public OperandValidator() {
    }

    public int countByExpression(String input) {
        assertNullOrBlank(input);
        assertStartWithNumber(input);

        return CountUtil.countByExpression(input, OPERAND_PATTERN);
    }

    private void assertNullOrBlank(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("빈 문자열은 허용하지 않습니다");
        }
    }

    private void assertStartWithNumber(String input) {
        int count = CountUtil.countByExpression(input, START_WITH_NUMBER_PATTERN);
        if (count == 0) {
            throw new IllegalArgumentException("연산식은 숫자로 시작해야 합니다 : " + input);
        }
    }

}
