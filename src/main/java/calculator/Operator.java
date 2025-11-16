package calculator;

public class Operator {

    public static int calculate(int operand1, int operand2, String operator) {
        OperatorType operatorType = OperatorType.from(operator);
        return operatorType.calculate(operand1, operand2);
    }
}
