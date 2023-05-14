package calculator.domain;

public class Calculator {

    public static Operand calculate(Operand operand1, Operator operator, Operand operand2) {
        return OperatorType.calculate(operand1, operator, operand2);
    }
}
