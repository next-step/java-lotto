package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class StringUtils {

    private static final String COMMA = ",";
    private static final String BLANK = " ";
    private static final String EMPTY = "";

    private StringUtils() { }

    public static List<Integer> convertToNumbers(String numberText) {
        String[] texts = splitBy(COMMA, numberText);
        return Arrays.stream(texts)
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }

    private static String[] splitBy(String regex, String text) {
        return removeBlank(text).split(regex);
    }

    private static String removeBlank(String text) {
        return text.replace(BLANK, EMPTY);
    }
}
