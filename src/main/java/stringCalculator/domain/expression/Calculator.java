package stringCalculator.domain.expression;


import stringCalculator.domain.expression.operator.Operator;
import stringCalculator.domain.expression.operator.impl.OperatorImpl;

public class Calculator {

    private Operators operators = new Operators();

    private Operands operands = new Operands();

    private long sum = 0;

    public void startCalculate() {
        sum = operands.poll();
        while (!operators.isEmpty()) {
            String operator = operators.poll();
            Integer operand = operands.poll();
            Operator op = OperatorImpl.fromOperator(operator);
            sum = op.calculate(sum, operand);
        }
    }

    public void classifyOperators(String[] parsedCalculationFormula) {
        for (String type : parsedCalculationFormula) {
            if (isOperators(type)) {
                operators.add(type);
            }

            if (isOperand((type))) {
                operands.add(Integer.parseInt(type));
            }
        }
    }

    private boolean isOperators(String operator) {
        return operators.isContainNumericalExpression(operator);
    }

    private boolean isOperand(String operand) {
        return operand.chars().anyMatch(Character::isDigit);

    }

    public long getSum() {
        return sum;
    }
}
