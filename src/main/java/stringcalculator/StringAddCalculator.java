package stringcalculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static final String DEFAULT_DELIMITERS = "[,:]";
    public static final String CUSTOM_DELIMITER_REGEX = "//(.)\\n(.*)";
    public static final int CUSTOM_DELIMITER_GROUP = 1;
    public static final int TEXT_GROUP = 2;

    public static int splitAndSum(String text) {
        if (isNullOrEmpty(text)) {
            return 0;
        }
        String[] tokens = split(text);
        NaturalNumber sum = Arrays.stream(tokens).map(NaturalNumber::valueOf)
                .reduce(NaturalNumber.valueOf(0), NaturalNumber::sum);
        return sum.getNumber();
    }

    private static String[] split(String text) {
        Matcher m = Pattern.compile(CUSTOM_DELIMITER_REGEX).matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(CUSTOM_DELIMITER_GROUP);
            return m.group(TEXT_GROUP).split(customDelimiter);
        }
        return text.split(DEFAULT_DELIMITERS);
    }

    private static boolean isNullOrEmpty(String text) {
        return text == null || text.isEmpty();
    }
}
