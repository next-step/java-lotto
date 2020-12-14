package lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringSplitter {

    private static final String COMMA = ",";
    private static final String BLANK = "";
    private static final String SPACE = " ";
    private static final int ZERO = 0;
    private static final String INCLUDE_NEGATIVE_VALUE_ERROR = "문자열에 음수값이 포함되어 있습니다.";

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
        if(number < ZERO) {
            throw new RuntimeException(INCLUDE_NEGATIVE_VALUE_ERROR);
        }
        return number;
    }

    private static String removeBlank(String input) {
        return input.replace(SPACE, BLANK);
    }
}
