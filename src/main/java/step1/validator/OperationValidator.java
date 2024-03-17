package step1.validator;

public class OperationValidator {

    private final ExpressionCount operatorValidator;
    private final ExpressionCount operandValidator;

    public OperationValidator() {
        this.operatorValidator = new OperatorValidator();
        this.operandValidator = new OperandValidator();
    }

    public void assertOperation(String input) {
        assertNullOrBlank(input);
        assertValidOperation(input);
    }

    private void assertNullOrBlank(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("빈 문자열은 허용하지 않습니다");
        }
    }

    private void assertValidOperation(String input) {
        int operand = operandValidator.countByExpression(input);
        int operator = operatorValidator.countByExpression(input);

        if (invalid(operand, operator)) {
            throw new IllegalArgumentException("유효한 연산식이 아닙니다 : " + input);
        }
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

}
