package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    public static final String DELIMITER = ",|:";

    private final Numbers numbers;

    public Calculator(String input) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);

        if (input.contains(",") || input.contains(":")) {
            String[] splitInput = input.split(DELIMITER);
            numbers = new Numbers(splitInput);
        } else if (m.find()) {
            String customDelimiter = m.group(1);
            String[] splitInput= m.group(2).split(customDelimiter);
            numbers = new Numbers(splitInput);
        } else {
            numbers = new Numbers(Integer.parseInt(input));
        }
    }

    public int sum() {
        return numbers.sum();
    }
}
