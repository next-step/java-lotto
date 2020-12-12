package stringcalculator.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputConvertor {

    private static final String REGEX = ",|:";
    private static final Pattern compile = Pattern.compile("//(.)\n(.*)");

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
        String separatorRegex = REGEX;
        String splitTarget = input;

        Matcher matcher = compile.matcher(input);
        if (matcher.find()) {
            separatorRegex += ("|" + matcher.group(1));
            splitTarget = matcher.group(2);
        }
        return splitTarget.split(separatorRegex);
    }

    private static boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }
}
