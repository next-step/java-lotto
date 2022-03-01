package calculator.domain;

import java.util.List;
import java.util.Objects;

public class Calculator {

    private static final int INTEGER_DEFAULT_VALUE = 0;

    public int add(String text, List<Integer> numbers) {
        if (isNullAndEmptyText(text)) {
            return INTEGER_DEFAULT_VALUE;
        }
        return numbers.stream().reduce(INTEGER_DEFAULT_VALUE, Integer::sum);
    }

    public boolean isNullAndEmptyText(String text) {
        return Objects.isNull(text) || text.isEmpty();
    }
}
