package study.step1.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    private final PositiveNumbers positiveNumberList;

    public Calculator(String input) {
        positiveNumberList = new PositiveNumbers(splitInput(input));
    }

    private String[] splitInput(String input) {
        String separator = ",|:";
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (m.find()) {
            separator = m.group(1);
            return m.group(2).split(separator);
        }
        return input.split(separator);
    }

    public int sum() {
        return positiveNumberList.sum();
    }

}
