package step2;

import java.util.Arrays;

public class StringAddCalculator {

    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String PATTERN = "^//.\\\\n.+$";

    public int execute(String text) {

        if (text == null || text.isEmpty()) {
            return 0;
        }

        if (text.length() == 1) {
            return Integer.parseInt(text);
        }

        return calculate(text);
    }

    private int calculate(String text) {

        String delimiter = DEFAULT_DELIMITER;

        if (text.matches(PATTERN)) {
            delimiter += "|" + text.charAt(2);
            text = text.substring(5);
        }

        return Arrays.stream(text.split(delimiter))
                     .mapToInt(this::toInt)
                     .sum();
    }

    private int toInt(String s) {

        int converted = Integer.parseInt(s);
        if (converted < 0) {
            throw new RuntimeException("양의 정수만 입력해주세요.");
        }

        return converted;
    }
}
