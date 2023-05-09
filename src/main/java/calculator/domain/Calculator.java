package calculator.domain;

public class Calculator {
    private final Operand operand1;
    private final Operator operator;
    private final Operand operand2;

    public Calculator(Double operand1, String operator, Double operand2) {
        this(new Operand(operand1), new Operator(operator), new Operand(operand2));
    }

    public Calculator(Operand operand1, Operator operator, Operand operand2) {
        this.operand1 = operand1;
        this.operator = operator;
        this.operand2 = operand2;
    }

    public static Operand calculate(Operand operand1, Operator operator, Operand operand2) {
        Double result = 0.0;
        if ("+".equals(operator.getOperator())) {
            result = OperatorType.PLUS.execute(operand1, operand2);
        }
        if ("-".equals(operator.getOperator())) {
            result = OperatorType.MINUS.execute(operand1, operand2);
        }
        if ("*".equals(operator.getOperator())) {
            result = OperatorType.MULTIPLE.execute(operand1, operand2);
        }
        if ("/".equals(operator.getOperator())) {
            result = OperatorType.DIVIDE.execute(operand1, operand2);
        }
        return new Operand(result);
    }
}
