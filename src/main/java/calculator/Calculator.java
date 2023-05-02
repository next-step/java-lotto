package calculator;

public class Calculator {
    private final Long operand1;
    private final String operator;
    private final Long operand2;

    public Calculator() {
        this(0L, "+", 0L);
    }

    public Calculator(Long operand1, String operator, Long operand2) {
        this.operand1 = operand1;
        this.operator = operator;
        this.operand2 = operand2;
    }

    public Long calculate(Long operand1, String operator, Long operand2) {
        if ("+".equals(operator)) {
            return operand1 + operand2;
        }
        if ("-".equals(operator)) {
            return operand1 - operand2;
        }
        if ("*".equals(operator)) {
            return operand1 * operand2;
        }
        if ("/".equals(operator)) {
            return operand1 / operand2;
        }
        return 0L;
    }
}
