package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static final int NULL_OR_EMPTY = 0;
    public static final int INITIAL_VALUE = 0;
    public static final int GET_FIRST_GROUP = 1;
    public static final int GET_SECOND_GROUP = 2;
    public static final String IS_NUMBER_REGEX = "[0-9]+";
    public static final String DEFAULT_SEPARATOR_REGEX = "[,:]";
    public static final Pattern CUSTOM_SEPARATOR = Pattern.compile("//(.)\n(.*)");
    public static final String IS_NOT_DUAL_NUMBER_ERROR_MESSAGE = "입력 값이 음수이거나 숫자가 아닙니다.";

    private StringAddCalculator() {
    }

    public static int splitAndSum(String input) {
        if (isNullOrEmpty(input)) {
            return NULL_OR_EMPTY;
        }

        String[] splitInputs = split(input);
        List<Integer> numbers = parsingNumber(splitInputs);

        validateNumbers(splitInputs, numbers);

        return sum(numbers);
    }

    private static boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }

    private static String[] split(String input) {
        Matcher matcher = CUSTOM_SEPARATOR.matcher(input);

        if (matcher.find()) {
            return splitByCustomSeparator(matcher);
        }

        return splitByDefaultSeparator(input);
    }

    private static String[] splitByCustomSeparator(Matcher matcher) {
        String customDelimiter = matcher.group(GET_FIRST_GROUP);
        return matcher.group(GET_SECOND_GROUP).split(customDelimiter);
    }

    private static String[] splitByDefaultSeparator(String input) {
        return input.split(DEFAULT_SEPARATOR_REGEX);
    }

    private static List<Integer> parsingNumber(String[] splitInputs) {
        List<Integer> numbers = new ArrayList<>();

        for (String input : splitInputs) {
            addByIsNumber(input, numbers);
        }

        return numbers;
    }

    private static void addByIsNumber(String input, List<Integer> numbers) {
        if (input.matches(IS_NUMBER_REGEX)) {
            numbers.add(Integer.parseInt(input));
        }
    }

    private static void validateNumbers(String[] splitInputs, List<Integer> numbers) {
        if (splitInputs.length != numbers.size()) {
            throw new RuntimeException(IS_NOT_DUAL_NUMBER_ERROR_MESSAGE);
        }
    }

    private static int sum(List<Integer> numbers) {
        int result = INITIAL_VALUE;

        for (int number : numbers) {
            result += number;
        }

        return result;
    }

}
