package calculator.domain;

public class Calculator {
    private final int INITIAL_VALUE_INDEX = 0;

    private final CurrentResult currentResult;
    private final ParsedFormula parsedFormula;

    public Calculator(String formula) {
        this.parsedFormula = new ParsedFormula(formula);
        this.currentResult = new CurrentResult(this.parsedFormula.getOperand(INITIAL_VALUE_INDEX));
    }

    public void calculateWholeFormula() {
        for (int currentPosition = 1; currentPosition < parsedFormula.getLength(); currentPosition += 2) {
            String operator = parsedFormula.getOperator(currentPosition);
            int operand = parsedFormula.getOperand(currentPosition + 1);

            operate(operator, operand);
        }
    }

    public int getCurrentResult() {
        return this.currentResult.getCurrentResult();
    }

    private void operate(String operator, int operand) {
        if (operator.equals("+")) {
            this.currentResult.updateResult(
                    add(this.getCurrentResult(), operand)
            );
        }

        if (operator.equals("-")) {
            this.currentResult.updateResult(
                    subtract(this.getCurrentResult(), operand)
            );
        }

        if (operator.equals("*")) {
            this.currentResult.updateResult(
                    multiply(this.getCurrentResult(), operand)
            );
        }

        if (operator.equals("/")) {
            this.currentResult.updateResult(
                    divide(this.getCurrentResult(), operand)
            );
        }
    }

    private int add(int a, int b) {
        return a + b;
    }

    private int subtract(int a, int b) {
        return a - b;
    }

    private int multiply(int a, int b) {
        return a * b;
    }

    private int divide(int a, int b) {
        return a / b;
    }
}
