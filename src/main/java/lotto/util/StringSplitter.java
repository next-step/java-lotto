package lotto.util;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringSplitter {

    public static final String COMMA = ",";
    public static final String BLANK = "";
    public static final String SPACE = " ";

    private StringSplitter() {
    }

    public static List<Integer> splitText(String text) {
        text = removeBlank(text);
        String[] texts = text.split(COMMA);
        return textToInt(texts);
    }

    private static List<Integer> textToInt(String[] texts) {
        return Stream.of(texts)
                .map(text -> validatePositiveNumber(text))
                .collect(Collectors.toList());
    }

    private static int validatePositiveNumber(String text) {
        int number = Integer.parseInt(text);
        if(number < 0) {
            throw new RuntimeException("문자열에 음수값이 포함되어 있습니다.");
        }
        return number;
    }

    private static String removeBlank(String input) {
        return input.replace(SPACE, BLANK);
    }
}
