package calculator;

public class Calculator {
    private final Double operand1;
    private final String operator;
    private final Double operand2;

    public Calculator() {
        this(0.0, "+", 0.0);
    }

    public Calculator(Double operand1, String operator, Double operand2) {
        this.operand1 = operand1;
        this.operator = operator;
        this.operand2 = operand2;
    }

    public Double calculate(Double operand1, String operator, Double operand2) {
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
        return 0.0;
    }
}
