package step2;

import java.util.Arrays;

public class StringParser {

    private static final StringParser instance = new StringParser();

    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String FULL_PATTERN = "^//.\\\\n.+$";
    private static final String START_PATTERN = "^//.\\\\n";
    private static final String BLANK = "";

    private StringParser() { }

    public static StringParser getInstance() {
        return instance;
    }

    public int[] toIntArray(String text) {

        String delimiter = DEFAULT_DELIMITER;

        if (text.matches(FULL_PATTERN)) {
            delimiter += "|" + text.charAt(2);
            text = text.replaceFirst(START_PATTERN, BLANK);
        }

        return Arrays.stream(text.split(delimiter))
                     .mapToInt(this::toInt)
                     .toArray();
    }

    private int toInt(String s) {

        int converted = Integer.parseInt(s);
        if (converted < 0) {
            throw new RuntimeException("양의 정수만 입력해주세요.");
        }

        return converted;
    }
}
