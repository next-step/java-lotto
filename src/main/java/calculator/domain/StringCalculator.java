package calculator.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private final String DEFAULT_DELIMITER = ":|,";
    private final String DEFAULT_REGEX_PATTERN = "//(.)\n(.*)";

    private int delimiterSection = 1;
    private int numbersSection = 2;

    public StringCalculator() { }

    public int calculate(String inputString) {
        if (isNullOrEmpty(inputString)) {
            return 0;
        }
        Numbers numbers = makeNumbersUsing(inputString);

        return numbers.sum();
    }

    public Numbers makeNumbersUsing(String inputString) {
        String delimiter = DEFAULT_DELIMITER;
        String numbersString = inputString;

        Matcher m = Pattern.compile(DEFAULT_REGEX_PATTERN).matcher(inputString);
        if (m.find()) {
            delimiter = m.group(delimiterSection);
            numbersString = m.group(numbersSection);
        }
        return new Numbers(numbersString.split(delimiter));
    }

    protected boolean isNullOrEmpty(String numberString) {
        return (numberString == null || numberString.equals(""));
    }

}
