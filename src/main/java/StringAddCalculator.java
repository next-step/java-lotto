import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class StringAddCalculator {
    private static final String REGEX_FOR_DEFAULT = ",|:";
    private static final String REGEX_FOR_CUSTOM = "//(.)\n(.*)";

    public static int addString(String input) {
        if (isNullOrEmpty(input)) {
            return 0;
        }
        return sum(convertFromStringToNumbers(input));
    }

    private static boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }

    private static int sum(PositiveNumbers positiveNumbers) {
        return positiveNumbers.sum();
    }

    private static PositiveNumbers convertFromStringToNumbers(String input) {
        List<String> strings = splitByCustom(input);
        return covertToNumber(strings);
    }

    private static List<String> splitByDefault(String input) {
        return Arrays.asList(input.split(REGEX_FOR_DEFAULT));
    }

    private static List<String> splitByCustom(String input) {
        Matcher m = Pattern.compile(REGEX_FOR_CUSTOM).matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return Arrays.asList(m.group(2).split(customDelimiter));
        }
        return splitByDefault(input);
    }

    private static PositiveNumbers covertToNumber(List<String> stringNumbers) {
        try {
            return stringNumbers.stream()
                    .map(stringNumber -> Integer.parseInt(stringNumber))
                    .map(PositiveNumber::new)
                    .collect(collectingAndThen(toList(), PositiveNumbers::new));
        } catch (NumberFormatException e) {
            throw new RuntimeException("숫자가 아닌 값은 입력할 수 없습니다.");
        }
    }
}