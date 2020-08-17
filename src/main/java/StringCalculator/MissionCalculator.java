package StringCalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MissionCalculator {
    public static final String DEFAULT_REGEX_DELIMITER = "[,;]";
    public static final int ZERO_VALUE = 0;
    public static final String CHECK_ONLY_NUMBER_INCLUDED = "\\d+";
    public static final String CHECK_CUSTOM_DELIMITER = "//(.)\n(.*)";
    private List<Integer> calculationArgument;

    public MissionCalculator() {
        this.calculationArgument = new ArrayList<>();
    }

    public int calculate() {
        return calculationArgument
                .stream()
                .reduce(Integer::sum)
                .get();
    }

    public int splitAndCalculate(String inputValue) {
        if (inputValue == null) {
            return ZERO_VALUE;
        }
        String[] value = splitInputString(inputValue);
        addIntegerValueForCalculation(value);
        return calculate();
    }

    private void addIntegerValueForCalculation(String[] value) {
        for (String input : value) {
            calculationArgument.add(validateInput(input));
        }
    }

    private int validateInput(String input) {
        if (isNullOrEmptyValue(input)) {
            return ZERO_VALUE;
        }
        if (isNegativeNumber(input) || isNonNumber(input)) {
            throw new RuntimeException();
        }
        return Integer.parseInt(input);
    }

    private boolean isNonNumber(String input) {
        return !input.matches(CHECK_ONLY_NUMBER_INCLUDED);
    }

    private boolean isNegativeNumber(String input) {
        return Integer.parseInt(input) < ZERO_VALUE;
    }

    private boolean isNullOrEmptyValue(String input) {
        return input == null || input.isEmpty();
    }

    private String[] splitInputString(String inputValue) {
        Matcher m = Pattern.compile(CHECK_CUSTOM_DELIMITER).matcher(inputValue);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return inputValue.split(DEFAULT_REGEX_DELIMITER);
    }
}
