package calculator.domain;

import calculator.util.ExpressionUtils;
import calculator.util.SplitStringUtils;

import java.util.Deque;

public class StringCalculator {
    private static final int ONLY_ONE_OPERAND = 1;

    private StringCalculator() {
    }

    public static int stringCalculate(String text) {
        Deque<String> postFixExpressionStack = ExpressionUtils.convertToPostFixExpression(SplitStringUtils.split(text));
        while (!postFixExpressionStack.isEmpty()) {
            if (postFixExpressionStack.size() == ONLY_ONE_OPERAND) {
                return new Operand(postFixExpressionStack.pollLast()).getNumber();
            }
            Operand firstOperand = new Operand(postFixExpressionStack.pollFirst());
            Operand secondOperand = new Operand(postFixExpressionStack.pollFirst());
            Operator operator = Operator.valueOfOperatorSymbol(postFixExpressionStack.pollFirst());
            postFixExpressionStack.offerFirst(String.valueOf(new Expression(firstOperand, operator, secondOperand).operation()));
        }
        return new Operand(postFixExpressionStack.pollLast()).getNumber();
    }
}
