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
                return Operand.create(postFixExpressionStack.pollLast()).getNumber();
            }
            Operand firstOperand = Operand.create(postFixExpressionStack.pollFirst());
            Operand secondOperand = Operand.create(postFixExpressionStack.pollFirst());
            Operator operator = Operator.valueOfOperatorSymbol(postFixExpressionStack.pollFirst());
            postFixExpressionStack.offerFirst(String.valueOf(new Expression(firstOperand, operator, secondOperand).operation()));
        }
        return Operand.create(postFixExpressionStack.pollLast()).getNumber();
    }
}
