package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    public static final String DELIMITER = ",|:";

    public static int calculate(String input) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);

        String[] splitInput;

        if(m.find()) {
            String customDelimiter = m.group(1);
            splitInput = m.group(2).split(customDelimiter);
        } else {
            splitInput = input.split(DELIMITER);
        }

        int sum = 0;

        for (String s : splitInput) {
            Number number = new Number(s);
            sum += number.getValue();
        }

        return sum;
    }
}
