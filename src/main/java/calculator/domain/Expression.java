package calculator.domain;

import calculator.util.StringUtil;

import java.util.regex.Pattern;

public class Expression {

    public static final String OPERAND_OPERATOR_OPERAND = "^\\d+ [-+*/] \\d+( [-+*/] \\d+)*$";
    private final String expression;

    public Expression(String expression) {
        validateExpression(expression);
        this.expression = expression;
    }

    private void validateExpression(String expression) {
        if (StringUtil.isEmpty(expression)) {
            throw new IllegalArgumentException("수식을 입력해 주세요.");
        }

        boolean isValidExpression = Pattern.matches(OPERAND_OPERATOR_OPERAND, expression);
        if (!isValidExpression) {
            throw new IllegalArgumentException("올바르지 않은 수식입니다.");
        }
    }
}
