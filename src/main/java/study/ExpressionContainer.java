package study;

import java.util.*;

public class ExpressionContainer {

    private static final int MIN_SIZE = 3;
    private static final int ONE = 1;

    private final Stack<String> EXPRESSION = new Stack<>();

    public ExpressionContainer(List<String> values) {
        if (values.size() < MIN_SIZE) {
            throw new IllegalArgumentException("계산 가능한 식이 아닙니다.");
        }
        Collections.reverse(values);
        EXPRESSION.addAll(values);
    }

    public int calculate() {
        while (!isComplete()) {
            Integer num1 = StringUtils.parseInt(EXPRESSION.pop());
            String operation = EXPRESSION.pop();
            Integer num2 = StringUtils.parseInt(EXPRESSION.pop());

            int result = OperationLinker.link(num1, num2, operation);
            EXPRESSION.push(String.valueOf(result));
        }

        return StringUtils.parseInt(EXPRESSION.pop());
    }

    private boolean isComplete() {
        return EXPRESSION.size() == ONE;
    }


}
