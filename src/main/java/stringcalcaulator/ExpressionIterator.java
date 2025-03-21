package stringcalcaulator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ExpressionIterator implements Iterator<String> {
    private final List<String> inputs;
    private int index = 0;

    public ExpressionIterator(String input) {
        if (isBlank(input)) {
            throw new IllegalArgumentException("입력값이 없습니다.");
        }

        inputs = Arrays.asList(split(input));
    }

    private static String[] split(String text) {
        return text.trim().split(" +");
    }

    private static boolean isBlank(String input) {
        return input == null || input.isBlank();
    }

    @Override
    public boolean hasNext() {
        return index < inputs.size();
    }

    @Override
    public String next() {
        if (!hasNext()) {
            throw new IllegalStateException("더 이상 가져올 요소가 없습니다.");
        }

        return inputs.get(index++);
    }
}
