package study;

import java.util.Arrays;

public class StringAddCalculator {
    private static final Integer INTEGER_ZERO = 0;
    private static final String VALIDATE_NUMBER_MESSAGE = "음수는 입력할 수 없습니다.";

    private StringAddCalculator() {
    }

    public static int splitAndSum(String str) {
        if (StringUtils.isBlank(str)) {
            return INTEGER_ZERO;
        }

        return sum(SplitString.splitStringByDelimiter(str));
    }

    private static int convertStringToNumber(String str) {
        int number = Integer.parseInt(str);

        if (number < INTEGER_ZERO) {
            throw new RuntimeException(VALIDATE_NUMBER_MESSAGE);
        }
        return number;
    }

    private static int sum(String[] strings) {
        return Arrays.stream(strings)
                .mapToInt(StringAddCalculator::convertStringToNumber)
                .reduce(INTEGER_ZERO, Integer::sum);
    }
}
