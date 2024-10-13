package calculator;

import java.util.function.IntBinaryOperator;

public class Calculation {

    public int calculate(StringExpression expression) {
        String[] splitedExpression = expression.getSplitedExpression();

        int result = Integer.parseInt(splitedExpression[0]);
        for (int i = 1; i < splitedExpression.length - 1; i += 2) {
            int operand = Integer.parseInt(splitedExpression[i + 1]);
            result = calculateTwoOperands(result, operand, splitedExpression[i]);
        }
        return result;
    }

    public IntBinaryOperator findOperator(String operatorToFind) {
        return Operator.getOperatorMethod(operatorToFind);
    }

    public int calculateTwoOperands(int firstOperand, int secondOperand, String operator) {
        return findOperator(operator).applyAsInt(firstOperand, secondOperand);
    }

}
