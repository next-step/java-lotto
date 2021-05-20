package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private final String DEFAULT_DELIMITER = ":|,";
    private int delimiterSection = 1;
    private int numbersSection = 2;

    private String numbersString;
    private String delimiter;

    public StringCalculator() {
        delimiter = DEFAULT_DELIMITER;
    }

    public boolean isNullOrZero(String numberString) {
        return (numberString == null || numberString.equals("0"));
    }

    public void putNumberString(String numberString) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(numberString);
        if (m.find()) {
            delimiter = m.group(delimiterSection);
            numbersString = m.group(numbersSection);
            return;
        }
        numbersString = numberString;
    }

    public String delimiter() {
        return delimiter;
    }

    public String numbersString() {
        return numbersString;
    }

    public Numbers numbers() {
        return new Numbers(numbersString.split(delimiter));
    }
}
