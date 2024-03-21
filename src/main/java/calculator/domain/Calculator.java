package calculator.domain;

import java.util.List;

public class Calculator {
    private final CurrentResult currentResult;
    private final ParsedFormula parsedFormula;

    public Calculator(String formula) {
        this.parsedFormula = new ParsedFormula(formula);
        this.currentResult = new CurrentResult(this.parsedFormula.getInitialValue());
    }

    public int calculateWholeFormula() {

        for (int currentPosition = 1; currentPosition < parsedFormula.getLength(); currentPosition += 2) {
            String operator = parsedFormula.getNextOperator(currentPosition);
            int operand = parsedFormula.getNextOperand(currentPosition);

            operate(operator, operand);
        }

        return this.currentResult.getCurrentResult();
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

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) {
        return a / b;
    }


}
