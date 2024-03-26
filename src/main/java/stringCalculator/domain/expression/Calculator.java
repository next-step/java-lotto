package stringCalculator.domain.expression;

import stringCalculator.domain.expression.operator.impl.OperatorImpl;

public class Calculator {

    private Operators operators = new Operators();

    private Operands operands = new Operands();

    private long sum = 0;

    public void startCalculate(String[] calculationFormula) {
        classifyOperators(calculationFormula);
        calculateSum();
    }

    public void classifyOperators(String[] parsedCalculationFormula) {
        for (String token : parsedCalculationFormula) {
            isOperators(token);
            isOperand((token));
        }
    }

    private void isOperators(String operator) {
        if (operators.isContainNumericalExpression(operator)) {
            operators.add(operator);
        }
    }

    private void isOperand(String operand) {
        if (operand.chars().anyMatch(Character::isDigit)) {
            operands.add(Integer.parseInt(operand));
        }
    }

    private void calculateSum() {
        sum = operands.poll();
        while (!operators.isEmpty()) {
            OperatorImpl operator = OperatorImpl.fromOperator(operators.poll());
            sum = operator.calculate(sum, operands.poll());
        }
    }

    public long getSum() {
        return sum;
    }
}
