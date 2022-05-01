package calculator;

import java.util.*;

public class ExpressionConverter {
    private ExpressionConverter() {
    }

    public static Deque<String> convertToPostFixExpression(List<String> inFixExpression) {
        Deque<String> postFixExpressionStack = new ArrayDeque<>();
        Deque<String> tempStack = new ArrayDeque<>();
        for (String element : inFixExpression) {
            if (Operator.isOperator(element)) {
                while (!tempStack.isEmpty()) {
                    postFixExpressionStack.add(tempStack.pollLast());
                }
                tempStack.offerLast(element);
                continue;
            }
            postFixExpressionStack.offerLast(element);
        }
        while (!tempStack.isEmpty()) {
            postFixExpressionStack.offerLast(tempStack.pollLast());
        }
        return postFixExpressionStack;
    }
}
