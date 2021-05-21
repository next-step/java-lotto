package study;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    static final String CUSTOM_SPLIT_PATTERN = "//(.)\n(.*)";
    static final String DEFAULT_SPLIT_PATTERN = ",|:";
    static final int CUSTOM_DELIMITER_SEQUENCE = 1;
    static final int CUSTOM_TARGET_SEQUENCE = 2;

    public static int splitAndSum(String data) {
        if (isEmptyOrNull(data)) {
            return 0;
        }
        List<String> stringNumbers = split(data);
        return sum(stringNumbers);
    }

    private static int sum(List<String> stringNumbers) {
        int sum = 0;
        for (String stringNumber : stringNumbers) {
            int number = Integer.parseInt(stringNumber);
            isNegativeNumber(number);
            sum += number;
        }
        return sum;
    }

    private static List<String> split(String data) {
        Matcher matcher = Pattern.compile(CUSTOM_SPLIT_PATTERN).matcher(data);
        if (matcher.find()) {
            return Arrays.asList(matcher.group(CUSTOM_TARGET_SEQUENCE).split(matcher.group(CUSTOM_DELIMITER_SEQUENCE)));
        }
        return Arrays.asList(data.split(DEFAULT_SPLIT_PATTERN));
    }

    private static boolean isEmptyOrNull(String inputData) {
        return (inputData == null || inputData.isEmpty());
    }

    private static void isNegativeNumber(int number){
        if (number < 0) {
            throw new RuntimeException("양수를 입력해주세요");
        }
    }
}
