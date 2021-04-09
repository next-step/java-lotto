package step1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static int splitAndSum(String text) {

        if (text == null || text.isEmpty()) {
            return 0;
        }

        String[] token = splitText(text);

        return stringAdd(token);
    }

    private static String[] splitText(String text) {

        if (text.startsWith("-")) {
            throw new IllegalArgumentException("음수가 발생했습니다.");
        }

        if (text.startsWith("/")) {
            return divideByCustomDelimiter(text);
        }

        return divideText(text);
    }

    private static String[] divideText(String text) {
        return text.split(",|:");
    }

    private static String[] divideByCustomDelimiter(String text) {

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens= m.group(2).split(customDelimiter);
            return tokens;
        }

        return null;
    }

    private static int stringAdd(String[] tokens) {
        // 덧셈 구현
        int result = 0;

        for (int i = 0; i < tokens.length; i++) {
            result += Integer.parseInt(tokens[i]);
        }
        return result;
    }

}
