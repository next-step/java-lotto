package stringcalcaulator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ExpressionIterator implements Iterator<String> {
    private final List<String> expressions;
    private int index = 0;

    public ExpressionIterator(String expression) {
        if (isBlank(expression)) {
            throw new IllegalArgumentException("입력값이 없습니다.");
        }

        expressions = Arrays.asList(split(expression));
    }

    private static String[] split(String text) {
        return text.trim().split(" +");
    }

    private static boolean isBlank(String input) {
        return input == null || input.isBlank();
    }

    @Override
    public boolean hasNext() {
        return index < expressions.size();
    }

    @Override
    public String next() {
        if (!hasNext()) {
            throw new IllegalStateException("더 이상 가져올 요소가 없습니다.");
        }

        return expressions.get(index++);
    }
}
