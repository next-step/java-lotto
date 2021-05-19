package study;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String DEFAULT_SEPARATOR = ",|:";
    private static final int MINIMUM_NUMBER = 0;
    private static final int ONE_SIZE_NUMBER = 1;
    private static final String CUSTOM_SEPARATOR = "//(.)\n(.*)";
    private static final Pattern CUSTOM_SEPARATOR_PATTERN = Pattern.compile(CUSTOM_SEPARATOR);
    private static final int CUSTOM_SEPARATOR_INDEX = 1;
    private static final int CUSTOM_SEPARATOR_SECOND_INDEX = 2;

    public int splitAndSum(String input) {
        if (!validateInput(input)) {
            return MINIMUM_NUMBER;
        }
        if (input.length() == ONE_SIZE_NUMBER) {
            return Integer.parseInt(input);
        }
        Numbers numbers = new Numbers(splitInput(input));
        return sumNumbers(numbers.getNumbers());
    }

    public boolean validateInput(String input) {
        if (input == null || input.isEmpty()) {
            return false;
        }
        return true;
    }

    public String[] splitInput(String input) {
        Matcher m = CUSTOM_SEPARATOR_PATTERN.matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(CUSTOM_SEPARATOR_INDEX);
            return m.group(CUSTOM_SEPARATOR_SECOND_INDEX).split(customDelimiter);
        }
        return input.split(DEFAULT_SEPARATOR);
    }

    public int sumNumbers(ArrayList<Integer> numbers) {
        int sum = 0;
        for (int i = 0; i < numbers.size(); i++) {
            sum += numbers.get(i);
        }
        return sum;
    }
}
