package lotto.step1;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private static final Pattern CUSTOM = Pattern.compile("//(.)\n(.*)");
    private static final String BASIC = "[,:]";

    public static int addString(String input) {
        return checkNullOrEmpty(input) ? 0 : sum(splitValue(input));
    }

    private static boolean checkNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }

    private static String[] splitValue(String input) {
        return isCustom(input) ? splitCustomPattern(input) : splitBasicPattern(input);
    }

    private static boolean isCustom(String input) {
        return CUSTOM.matcher(input).matches();
    }

    private static String[] splitCustomPattern(String input) {
        Matcher matcher = CUSTOM.matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }
        return null;
    }

    private static String[] splitBasicPattern(String input) {
        String[] split = input.split(BASIC);
        Arrays.stream(split)
                .forEach(StringCalculator::checkDelimiter);
        return split;
    }

    private static void checkDelimiter(String input) {
        if (input.length() > 1) {
            throw new RuntimeException("구분자 잘못 입력");
        }
    }

    private static int sum(String[] input) {
        Arrays.stream(input)
                .forEach(StringCalculator::checkMinusOrNotNumber);
        return Arrays.stream(input)
                .mapToInt(Integer::valueOf)
                .sum();
    }

    private static void checkMinusOrNotNumber(String input) {
        for (char c : input.toCharArray()) {
            notDigitThrowException(c);
        }
    }

    private static void notDigitThrowException(char c) {
        if (!Character.isDigit(c)) {
            throw new RuntimeException("0 이상 숫자 값을 넣어주세요");
        }
    }

}
