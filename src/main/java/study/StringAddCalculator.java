package study;

import java.util.ArrayDeque;

public class StringAddCalculator {
    private final ArrayDeque<Integer> expression;

    public StringAddCalculator(Expression expression) {
        this.expression = expression.convertToQueue();
    }

    public int sum() {
        int result = 0;
        while(!expression.isEmpty()) {
            result += expression.poll();
        }
        return result;
    }
}
