package stringcalcaulator.domain;

import java.util.Iterator;
import java.util.StringTokenizer;

public class ExpressionIterator implements Iterator<String> {
    private final StringTokenizer tokenizer;

    public ExpressionIterator(String expression) {
        validate(expression);
        this.tokenizer = new StringTokenizer(expression, " ");
    }

    private static boolean isBlank(String input) {
        return input == null || input.isBlank();
    }

    private static void validate(String expression) {
        if (isBlank(expression)) {
            throw new IllegalArgumentException("입력값이 없습니다.");
        }

        if (isInvalidInput(expression)) {
            throw new IllegalArgumentException("입력값이 올바르지 않습니다.");
        }
    }

    private static boolean isInvalidInput(String input) {
        return !input.matches("^[0-9+\\-*/\\s]+$");
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
