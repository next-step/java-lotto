package calculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class NumberGenerator {
    private NumberGenerator() {}

    public static List<Number> generate(final String input) {
        return Arrays.stream(StringParser.parse(input))
                .map(Number::new)
                .collect(Collectors.toList());
    }
}
