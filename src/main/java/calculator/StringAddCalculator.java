package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class StringAddCalculator {
    private final static int BLANK_NUMBER = 0;

    private final static String DELIMITER_PATTERN = "//(.)\n(.*)";
    private final static String BASE_DELIMITER = "[,:]";

    public static int splitAndSum(String text) {

        if (isBlankString(text)) {
            return BLANK_NUMBER;
        }

        Matcher m = Pattern.compile(DELIMITER_PATTERN).matcher(text);
        String[] splitText = null;

        if (m.find()) {
            splitText = m.group(2).split(m.group(1));
        }

        if (splitText == null) {
            splitText = text.split(BASE_DELIMITER);
        }

        return Arrays.stream(getValidNumber(splitText)).reduce(Integer::sum).orElse(0);
    }

    private static boolean isBlankString(String text) {
        return text == null || text.isEmpty();
    }

    private static int[] getValidNumber(String[] tokens) {
        int[] elements = Arrays.stream(tokens).mapToInt(Integer::parseInt).toArray();
        if (Arrays.stream(elements).filter(x -> x < 0).toArray().length != 0) {
            throw new RuntimeException("음수는 사용할 수 없습니다.");
        }

        return elements;
    }
    
}
