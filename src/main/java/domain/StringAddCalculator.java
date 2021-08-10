package domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String DEFAULT_DELIMITER_REGEX = ",|:";

    private static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";

    private static final int LIMIT_NUMBER = 0;

    private static final int DELIMITER_INDEX = 1;

    private static final int NUMBERS_INDEX = 2;

    public static int splitAndSum(String data) {
        if (data == null || data.isEmpty()) {
            return 0;
        }

        String[] numbers = parseData(data);

        return sumData(numbers);
    }

    public static String[] parseData(String data) {
        if (Pattern.compile(CUSTOM_DELIMITER_REGEX).matcher(data).find()) {
            return parseDataWithCustomDelimiter(data);
        }
        String[] numbers = data.split(DEFAULT_DELIMITER_REGEX);
        return numbers;
    }


    public static String[] parseDataWithCustomDelimiter(String data) {
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_REGEX).matcher(data);
        matcher.find();
        
        String customDelimiter = matcher.group(DELIMITER_INDEX);
        String[] numbers = matcher.group(NUMBERS_INDEX).split(customDelimiter);

        return numbers;
    }


    public static int sumData(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            sum += getPositiveNumber(number);
        }
        return sum;
    }

    public static int getPositiveNumber(String number) {
        int positiveNumber = Integer.parseInt(number);
        if (positiveNumber < LIMIT_NUMBER) {
            throw new RuntimeException("음수 값은 들어올 수 없습니다.");
        }
        return positiveNumber;
    }
}
