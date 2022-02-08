package calculator.domain;

import java.util.List;
import java.util.Objects;

public class Calculator {

    private static final int INTEGER_DEFAULT_VALUE = 0;

    public Calculator() {
    }

    public int add(String text) {
        if (Objects.isNull(text) || text.isEmpty()) {
            return INTEGER_DEFAULT_VALUE;
        }

        final DelimiterTokenizer delimiterTokenizer = new DelimiterTokenizer(text);
        final Parser parser = new Parser(text, delimiterTokenizer.parseDelimiters());
        final List<Integer> numbers = parser.splitNumbersByDelimiter();
        return numbers.stream()
            .mapToInt(Integer::valueOf)
            .sum();
    }
}

