package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private String numbers;
    private String delimiter;

    private final String DEFAULT_DELIMITER = ":|,";
    private int delimiterSection = 1;
    private int numbersSection = 2;

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
            numbers = m.group(numbersSection);
            return;
        }
        numbers = numberString;
    }

    public String delimiter() {
        return delimiter;
    }

    public String numbers() {
        return numbers;
    }
}
