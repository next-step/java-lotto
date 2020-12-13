package stringcalculator.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputConvertor {

    private static final String DEFAULT_SPLIT_REGEX = ",|:";
    private static final Pattern CUSTOM_SPLIT_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final int CUSTOM_DELIMITER_INDEX = 1;
    private static final int SPLIT_TARGET_INDEX = 2;

    public static List<Integer> convert(String input) {
        if (isNullOrEmpty(input)) {
            return Collections.singletonList(0);
        }

        return convertToIntegerList(input);
    }

    private static List<Integer> convertToIntegerList(String input) {
        return Stream.of(input)
                .flatMap(inputStream -> Arrays.stream(getTokens(inputStream)))
                .map(Integer::parseInt)
                .map(InputConvertor::validNumber)
                .collect(Collectors.toList());
    }

    private static Integer validNumber(Integer number) {
        if(isNegativeNumber(number))
            throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
        return number;
    }

    private static boolean isNegativeNumber(int number) {
        return number < 0;
    }

    private static String[] getTokens(String input) {
        Matcher matcher = CUSTOM_SPLIT_PATTERN.matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(CUSTOM_DELIMITER_INDEX);
            return matcher.group(SPLIT_TARGET_INDEX).split(customDelimiter);
        }
        return input.split(DEFAULT_SPLIT_REGEX);
    }

    private static boolean isNullOrEmpty(String input) {
        return input == null || input.trim().isEmpty();
    }
}
