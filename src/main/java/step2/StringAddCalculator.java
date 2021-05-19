package step2;

import java.util.Arrays;

public class StringAddCalculator {

    public int execute(String text) {

        if (isEmpty(text)) {
            return 0;
        }

        return calculate(text);
    }

    private boolean isEmpty(String text) {
        return text == null || text.isEmpty();
    }

    private int calculate(String text) {
        StringParser parser = StringParser.getInstance();
        return Arrays.stream(parser.toIntArray(text))
                     .sum();
    }
}
