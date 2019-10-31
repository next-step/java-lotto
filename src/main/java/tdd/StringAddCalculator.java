package tdd;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static tdd.Numbers.INIT_RESULT_VALUE;

public class StringAddCalculator {

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

        Numbers numbers = new Numbers(text.split(delimiter));
        return numbers.addAll();
    }
}
