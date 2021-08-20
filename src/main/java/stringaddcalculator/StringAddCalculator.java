package stringaddcalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private Number number;

    public int splitAndSum(String input) {
        if (isNullOrEmpty(input)) {
            return Number.ZERO;
        }

        String[] inputs = splitIntoDelimiter(input);

        for (String singleInput : inputs) {
            number = new Number(Integer.parseInt(singleInput));
        }
        return number.sumValue(inputs);
    }

    private boolean isNullOrEmpty(String input) {
        return input == null || input.trim().isEmpty();
    }

    private String[] splitIntoDelimiter(String input) {
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(input);

        if(matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }
        return input.split(",|:");
    }
}
