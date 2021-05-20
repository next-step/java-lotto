package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private final String DEFAULT_DELIMITER = ":|,";
    private int delimiterSection = 1;
    private int numbersSection = 2;

    private String numbersString;
    private String delimiter;
    private Numbers numbers;

    public StringCalculator() { }

    public boolean isNullOrZero(String numberString) {
        return (numberString == null || numberString.equals("0"));
    }

    public void putNumberString(String inputString) {
        splitDelimiterAndNumbers(inputString);
        numbers = new Numbers(numbersString.split(delimiter));
    }

    private void splitDelimiterAndNumbers(String inputString) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(inputString);
        if (m.find()) {
            delimiter = m.group(delimiterSection);
            numbersString = m.group(numbersSection);
            return;
        }
        delimiter = DEFAULT_DELIMITER;
        numbersString = inputString;
    }

    public int calculate() {
        return numbers.sum();
    }

    public String delimiter() {
        return delimiter;
    }

    public String numbersString() {
        return numbersString;
    }

    public Numbers numbers() {
        return numbers;
    }

}
