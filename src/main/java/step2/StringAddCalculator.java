package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static int splitAndSum(String text) {
        if (isNullOrEmpty(text)) return 0;
        if (hasOneSize(text)) return Integer.parseInt(text);

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            return getSumOfTokens(m.group(2), m.group(1));
        }
        return getSumOfTokens(text,",|:");
    }

    private static boolean hasOneSize(String text) {
        return text.length() == 1;
    }

    private static boolean isNullOrEmpty(String text) {
        return text == null || text.isEmpty();
    }

    private static int getSumOfTokens(String text, String delimiter) {
        String[] tokens = findNoNegativeTokens(text, delimiter);
        return calculateTokens(tokens);
    }

    private static String[] findNoNegativeTokens(String input, String delimiter) {
        String[] result = input.split(delimiter);
        for (int i = 0; i < result.length; ++i) {
            negativeCheck(result[i]);
        }
        return result;
    }

    private static void negativeCheck(String text) {
        if (Integer.parseInt(text) < 0)
            throw new RuntimeException("음수 입니다.");
    }

    private static int calculateTokens(String[] tokens) {
        int sum = 0;
        for (int i = 0; i < tokens.length; ++i) sum += Integer.parseInt(tokens[i]);
        return sum;
    }
}
