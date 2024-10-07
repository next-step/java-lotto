package step1;

import step1.operater.Operater;

public class Calculator {

    private String calculation;
    private int result;

    public Calculator(String input) {
        calculation = input;
        deleteSpace();
    }

    public void deleteSpace() {
        this.calculation = calculation.replace(" ", "");
    }

    public String getString() {
        return this.calculation;
    }

    public int calculateExpression() {
        result = Integer.parseInt(calculation.charAt(0) + "");
        for (int i = 1; i < calculation.length() - 1; i += 2) {
            int operand = Integer.parseInt(calculation.charAt(i + 1) + "");
            Operater operater = OperatorSelection.selection(calculation.charAt(i) + "");
            result = operater.calculate(result, operand);
        }
        return result;
    }
}
