package calculator;

public class Calculator {

    public static int calculate(String formula) {
        String[] formulaElements = getFormulaElements(formula);
        int interimResult = getFirstElement(formulaElements);
        for(int i = 1; i < formulaElements.length; i += 2) {
            interimResult = calculate(interimResult, getOperator(i, formulaElements), getOperand(i, formulaElements));
        }
        return interimResult;
    }

    private static String[] getFormulaElements(String formula) {
        if (formula == null || formula.isBlank()) {
            throw new IllegalArgumentException("계산 식은 null 혹은 공백일 수 없습니다");
        }
        return formula.split(" ");
    }

    private static int getFirstElement(String[] formulaElements) {
        return Integer.parseInt(formulaElements[0]);
    }

    private static int calculate(int operand1, String operator, int operand2) {
        return ArithmeticOperator.calculate(operand1, operator, operand2);
    }

    private static String getOperator(int index, String[] formulaElements) {
        return formulaElements[index];
    }

    private static int getOperand(int index, String[] formulaElements) {
        return Integer.parseInt(formulaElements[index + 1]);
    }
}
