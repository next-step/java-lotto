package StringCalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MissionCalculator {
    public static final String DEFAULT_REGEX_DELIMITER = "[,;]";
    private List<Integer> calculationArgument;

    public MissionCalculator(String[] value) {
        this.calculationArgument = new ArrayList<>();
        for (String input : value) {
            calculationArgument.add(Integer.valueOf(input));
        }
    }

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
            return 0;
        }
        String[] value = splitInputString(inputValue);
        for (String input : value) {
            calculationArgument.add(validateInput(input));
        }
        return calculate();
    }

    private int validateInput(String input) {
        if (isNullOrEmptyValue(input)) {
            return 0;
        }
        if (isNegativeNumber(input) || isNonNumber(input)) {
            throw new RuntimeException();
        }
        return Integer.parseInt(input);
    }

    private boolean isNonNumber(String input) {
        return !input.matches("\\d+");
    }

    private boolean isNegativeNumber(String input) {
        return Integer.parseInt(input) < 0;
    }

    private boolean isNullOrEmptyValue(String input) {
        return input == null || input.isEmpty();
    }

    private String[] splitInputString(String inputValue) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(inputValue);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return inputValue.split(DEFAULT_REGEX_DELIMITER);
    }
}
