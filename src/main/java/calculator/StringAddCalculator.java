package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static final String IS_NUMBER_REGEX = "[0-9]+";
    public static final String DEFAULT_SEPARATOR_REGEX = "[,:]";
    public static final Pattern CUSTOM_SEPARATOR = Pattern.compile("//(.)\n(.*)");

    public StringAddCalculator() {
    }

    public static int splitAndSum(String input) {
        // validate
        if (input == null || input.isEmpty()) {
            return 0;
        }

        // 숫자인지아닌지 사이즈비교

        List<Integer> numbers = split(input);

        return sum(numbers);
    }

    private static List<Integer> split(String input) {
        Matcher matcher = CUSTOM_SEPARATOR.matcher(input);

        if (matcher.find()) {
            return parsingNumber(splitByCustomSeparator(matcher));
        }

        return parsingNumber(splitByDefaultSeparator(input));
    }

    private static String[] splitByCustomSeparator(Matcher matcher) {
        String customDelimiter = matcher.group(1);
        return matcher.group(2).split(customDelimiter);
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

    private static int sum(List<Integer> numbers) {
        int result = 0;

        for (int number : numbers) {
            result += number;
        }

        return result;
    }

}
