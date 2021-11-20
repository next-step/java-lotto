package calculator;

import java.util.Arrays;

public class StringAddCalculator {

    private final Splitter splitter = new Splitter();

    public int calculate(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }

        String[] split = splitter.split(text);

        if (Arrays.stream(split)
                .mapToInt(Integer::parseInt)
                .filter(num -> num < 0)
                .findAny()
                .isPresent()) {
            throw new RuntimeException();
        };

        return Arrays.stream(split).mapToInt(Integer::parseInt).sum();
    }
}
