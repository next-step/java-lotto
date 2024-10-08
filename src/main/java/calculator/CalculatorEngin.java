package calculator;

public class CalculatorEngin {
    public static int add(Operand operand1, Operand operand2) {
        return operand1.getValue() + operand2.getValue();
    }

    public static int subtract(Operand operand1, Operand operand2) {
        return operand1.getValue() - operand2.getValue();
    }

    public static int multiply(Operand operand1, Operand operand2) {
        return operand1.getValue() * operand2.getValue();
    }

    public static int divide(Operand operand1, Operand operand2) {
        return operand1.getValue() / operand2.getValue();
    }
}
