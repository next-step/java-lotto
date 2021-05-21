package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String DEFAULT_DELIMITER_PATTERN = ",|:";
    private static final String CUSTOM_DELIMITER_PATTERN = "//(.)\n(.*)";

    public static int splitAndSum(String inputText) {
        if (isNullOrEmpty(inputText))
            return 0;
        if (inputText.length() == 1)
            return Integer.parseInt(inputText);

        String[] parsedText = parsingInputText(inputText);
        return sum(parsedText);
    }

    public static String[] parsingInputText(String text) {
        Matcher m = Pattern.compile(CUSTOM_DELIMITER_PATTERN).matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1) + "|" + DEFAULT_DELIMITER_PATTERN;
            String[] tokens = m.group(2).split(customDelimiter);
            return tokens;
        }
        String[] tokens = text.split(DEFAULT_DELIMITER_PATTERN);
        return tokens;
    }

    private static int validatedToken(String token) {
        int parsedToken = Integer.parseInt(token);
        if (parsedToken < 0)
            throw new RuntimeException("양수만 입력 가능합니다.");

        return parsedToken;
    }

    public static int sum(String[] parsedTexts) {
        int sum = 0;
        for (String parsedText : parsedTexts) {
            sum += validatedToken(parsedText);
        }
        return sum;
    }

    private static boolean isNullOrEmpty(String inputText) {
        return inputText == null || inputText.isEmpty();
    }
}
