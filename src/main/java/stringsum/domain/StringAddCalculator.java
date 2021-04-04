package stringsum.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static String[] remainedNumbers(String inputText) {

        //custom
        if (inputText.charAt(0) == '/') {
            return dividedTextByCustomer(inputText);
        }

        return dividedText(inputText);
    }

    private static String[] dividedTextByCustomer(String inputText) {

        // java.util.regex 패키지의 Matcher, Pattern import
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(inputText);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens = m.group(2).split(customDelimiter);
            // 덧셈 구현
            return tokens;
        }

        return null;

    }

    private static String[] dividedText(String inputText) {
        return inputText.split(",|:");
    }

    public static int sum(String[] numbers) {
        int sumNumber = 0;
        for (String numStr : numbers) {
            int number = Integer.parseInt(numStr);
            if (number < 0) {
                throw new IllegalArgumentException("음수가 나왔습니다.");
            }
            sumNumber += number;
        }

        return sumNumber;
    }


    public static int splitAndSum(final String inputText) {

        if (inputText == null || inputText.isEmpty()) {
            return 0;
        }

        String[] splitNumbers = remainedNumbers(inputText);

        return sum(splitNumbers);
    }
}
