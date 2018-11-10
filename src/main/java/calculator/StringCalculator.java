package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private static String REGEX_BASE_DIVIDER = ",|:";
    private static String DIVIDER_GROUP_NAME = "divider";
    private static String SOURCE_GROUP_NAME = "source";
    private static String REGEX_CUSTOM_DIVIDER = "//(?<divider>[^0-9]+)\n(?<source>.*)";

    public static int add(String source) {
        if (source == "") {
            return 0;
        }

        Matcher matcher = generateMatcher(source);
        List<String> splitedValues = matcher.find() ?
                splitSourceByDivider(matcher.group(SOURCE_GROUP_NAME), matcher.group(DIVIDER_GROUP_NAME)) :
                splitSourceByDivider(source, REGEX_BASE_DIVIDER);
        List<Integer> values = convertIntegerValues(splitedValues);

        return sumValues(values);
    }

    private static List<String> splitSourceByDivider(String source, String divider) {
        return Arrays.asList(source.split(divider));
    }

    private static Matcher generateMatcher(String source) {
        Pattern pattern = Pattern.compile(REGEX_CUSTOM_DIVIDER);
        return pattern.matcher(source);
    }

    private static List<Integer> convertIntegerValues(List<String> values) {
        List<Integer> results = new ArrayList<>();
        for (String value : values) {
            results.add(parseInt(value));
        }
        return results;
    }

    private static int parseInt(String value) {
        int result = 0;

        try {
            result = Integer.parseInt(value);
        } catch(NumberFormatException exception) {
            throw new RuntimeException("숫자 이외의 타입은 허용하지 않습니다.");
        } finally {
            if (result < 0) {
                throw new RuntimeException("음수는 허용하지 않습니다.");
            }
        }

        return result;
    }

    private static int sumValues(List<Integer> values) {
        int result = 0;
        for (int value : values) {
            result += value;
        }
        return result;
    }
}
