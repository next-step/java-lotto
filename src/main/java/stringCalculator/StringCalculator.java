package stringCalculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public int add(final String text) {

        if (text == null || text.isEmpty()) { return 0; }

        return sum(getNumbers(text));
    }

    private String[] getNumbers(String text) {
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        } else {
            return text.split(",|:");
        }
    }

    private int sum(String[] numbers) {
        return Arrays.stream(numbers)
                .map(this::parsePositiveNumber)
                .reduce(0, Integer::sum);
    }

    private int parsePositiveNumber(String text) {
        if (Integer.parseInt(text) >= 0) {
            return Integer.parseInt(text);
        } else {
            throw new RuntimeException();
        }
    }
}
