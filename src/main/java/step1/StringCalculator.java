package step1;

import step1.operater.Operater;

public class StringCalculator {

    private String calculation;
    private int result;

    public StringCalculator(String input) {
        validInput(input);
        calculation = input;
        deleteSpace();
    }

    public void deleteSpace() {
        this.calculation = calculation.replace(" ", "");
    }

    public String getString() {
        return this.calculation;
    }

    private static void validInput(String input) {
        if(input == null || input.isEmpty()){
            throw new IllegalArgumentException("올바르지 않은 계산 식 (null 혹은 빈문자열)");
        }
    }

    public int calculateExpression() {
        result = Integer.parseInt(calculation.charAt(0) + "");
        for (int i = 1; i < calculation.length() - 1; i += 2) {
            int operand = Integer.parseInt(calculation.charAt(i + 1) + "");
            Operater operater = OperaterSelection.selection(calculation.charAt(i) + "");
            result = operater.calculate(result, operand);
        }
        return result;
    }
}
