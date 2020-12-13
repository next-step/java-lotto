package stringcalculator.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        String[] tokens = getTokens(input);

        List<Integer> result = new ArrayList<>();
        for (String token : tokens) {
            int number = Integer.parseInt(token);
            validNumber(number);
            result.add(number);
        }
        return result;
    }

    private static void validNumber(int number) {
        if(isNagativeNumber(number))
            throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
    }

    private static boolean isNagativeNumber(int number) {
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
