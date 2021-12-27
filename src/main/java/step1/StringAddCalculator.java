package step1;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String CUSTOM_REGEX_PATTERN = "//(.)\n(.*)";
    private static final String COMMA_OR_COLON = ",|:";
    private static final int REGEX_GROUP_FIRST = 1;
    private static final int REGEX_GROUP_SECOND = 2;
    private static final String ILLEGAL_ARGUMENT_NAGATIVE_MSG = "음수의 계산은 지원하지 않습니다.";

    private StringAddCalculator() {
        throw new AssertionError();
    }

    public static int splitAndSum(String inputData) {
        if (isEmpty(inputData)) {
            return 0;
        }

        List<Integer> numbers = convertIntegers(split(inputData));

        if (isNumberOfOne(numbers)) {
            return numbers.get(0);
        }
        return sum(numbers);
    }

    private static String[] split(String inputData) {
        String[] tokens = inputData.split(COMMA_OR_COLON);
        Matcher m = Pattern.compile(CUSTOM_REGEX_PATTERN).matcher(inputData);
        if (m.find()) {
            String customDelimiter = m.group(REGEX_GROUP_FIRST);
            tokens= m.group(REGEX_GROUP_SECOND).split(customDelimiter);
        }
        return tokens;
    }

    private static int sum(List<Integer> numbers) {
        int result = 0;
        for (Integer number : numbers) {
            result += number;
        }
        return result;
    }

    private static boolean isNumberOfOne(List<Integer> numbers) {
        return numbers.size() == 1;
    }

    private static List<Integer> convertIntegers(String[] splits) {
        List<Integer> numbers = new ArrayList<>();
        for (String split : splits) {
            int number = convertPositive(split);
            numbers.add(number);
        }
        return numbers;
    }

    private static int convertPositive(String split) {
        int number = Integer.parseInt(split);
        if (number < 0) throw new IllegalArgumentException(ILLEGAL_ARGUMENT_NAGATIVE_MSG);
        return number;
    }

    private static boolean isEmpty(String inputData) {
        return inputData == null || inputData.trim().isEmpty();
    }
}
