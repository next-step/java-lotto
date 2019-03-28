package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final int EMPTY_OR_NULL_NUMBER = 0;
    private static final String SET_DELIMITERS = ",|:";

    public int add(String input) {
        if (isEmptyOrNull(input)) return EMPTY_OR_NULL_NUMBER;

        List<Integer> numberValues = split(input);
        return numberValues.stream().mapToInt(i -> i.intValue()).sum();
    }

    public List<Integer> split(String input) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (m.find()) {
            return makeCollection(splitUsingPattern(m));
        }

        return makeCollection(splitUsingDelimiter(input));
    }

    public List<Integer> makeCollection(String[] tokens) {
        List<String> values = new ArrayList<String>(Arrays.asList(tokens));
        List<Integer> numberValues = new ArrayList<Integer>(values.size());

        for (String value : values) {
            numberValues.add(Integer.parseInt(isValidNumber(value)));
        }

        return numberValues;
    }

    public String[] splitUsingPattern(Matcher m) {
        String customDelimiter = m.group(1);
        return m.group(2).split(customDelimiter);
    }

    public String[] splitUsingDelimiter(String input) {
        return input.split(SET_DELIMITERS);
    }

    public boolean isEmptyOrNull(String input) {
        return (input == null || input.isEmpty());
    }

    public String isValidNumber(String input) throws RuntimeException {
        if (Integer.parseInt(input) < 0) {
            throw new RuntimeException();
        }
        return input;
    }
}