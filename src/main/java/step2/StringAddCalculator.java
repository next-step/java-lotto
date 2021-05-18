package step2;

import java.util.Arrays;

public class StringAddCalculator {

    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String FULL_PATTERN = "^//.\\\\n.+$";
    private static final String START_PATTERN = "^//.\\\\n";
    private static final String BLANK = "";

    public int execute(String text) {

        if (isEmpty(text)) {
            return 0;
        }

        if (isSingleSizeString(text)) {
            return Integer.parseInt(text);
        }

        return calculate(text);
    }

    private boolean isEmpty(String text) {
        return text == null || text.isEmpty();
    }

    private boolean isSingleSizeString(String text) {
        return text.length() == 1;
    }

    private int calculate(String text) {

        String delimiter = DEFAULT_DELIMITER;

        if (text.matches(FULL_PATTERN)) {
            delimiter += "|" + text.charAt(2);
            text = text.replaceFirst(START_PATTERN, BLANK);
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
