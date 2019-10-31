package tdd;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final int INIT_RESULT_VALUE = 0;
    private static final String DEFAULT_DELIMITER = ",|:";

    public int add(String inputText) {
        if (inputText == null || inputText.isEmpty()) {
            return INIT_RESULT_VALUE;
        }

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(inputText);

        String delimiter = DEFAULT_DELIMITER;
        String text = inputText;
        if (m.find()) {
            String customDelimiter = m.group(1);
            delimiter = delimiter + "|" + customDelimiter;
            text = m.group(2);
        }

        String[] numbers = text.split(delimiter);

        int result = INIT_RESULT_VALUE;
        for (String each : numbers) {
            int number = Integer.valueOf(each);
            result += number;
        }

        return result;
    }
}
