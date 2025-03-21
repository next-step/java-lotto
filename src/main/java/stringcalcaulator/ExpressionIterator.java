package stringcalcaulator;

import java.util.Iterator;
import java.util.StringTokenizer;

public class ExpressionIterator implements Iterator<String> {
    private final StringTokenizer tokenizer;

    public ExpressionIterator(String expression) {
        if (isBlank(expression)) {
            throw new IllegalArgumentException("입력값이 없습니다.");
        }

        this.tokenizer = new StringTokenizer(expression, " ");
    }

    private static boolean isBlank(String input) {
        return input == null || input.isBlank();
    }

    @Override
    public boolean hasNext() {
        return tokenizer.hasMoreTokens();
    }

    @Override
    public String next() {
        return tokenizer.nextToken();
    }
}
