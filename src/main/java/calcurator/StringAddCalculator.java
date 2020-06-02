package calcurator;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final Pattern CUSTOM_PATTERN = Pattern.compile("//(.)\n(.*)");

    public static int splitAndSum(String input) {
        if (checkNullOrEmpty(input))
            return Const.INITIAL_NUMBER_ZERO;

        String[] splitInputs = splitSeparator(input);
        return addSum(splitInputs);
    }

    private static boolean checkNullOrEmpty(String input) {
        return (input == null || input.isEmpty());
    }

    private static String[] splitSeparator(String input) {
        Matcher matcher = CUSTOM_PATTERN.matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(Const.PATTERN_SEPARATOR_INDEX);
            return matcher.group(Const.PATTERN_SEPARATOR_INPUTS).split(customDelimiter);
        }
        return input.split(Const.SYMBOL_COMMA_AND_COLON);
    }

    private static int addSum(String[] inputs) {
        AtomicInteger sumNumber = new AtomicInteger();
        Arrays.stream(inputs).forEach(numberString -> {
            int parseInt = Integer.parseInt(numberString);
            if (parseInt < Const.ZERO_NUM) {
                throw new RuntimeException("양수를 입력해주세요.");
            }
            sumNumber.addAndGet(parseInt);
        });
        return sumNumber.get();
    }
}
