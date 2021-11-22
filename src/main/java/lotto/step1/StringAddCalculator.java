package lotto.step1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");

    private static final String DEFAULT_SEPARATOR = ",|:";
    private static final String MSG_OR = "|";
    private static final String CUTTING_MSG = "\n";

    private static final int FIRST_MATCHED = 1;
    private static final int ZERO = 0;

    private StringAddCalculator() {
        throw new AssertionError();
    }

    public static int splitAndSum(String input) {

        if(input == null || input.trim().isEmpty()) {
            return ZERO;
        }

        String separator = createSeparator(input);
        int result = startCalculator(separator, input);

        return result;
    }

    private static String createSeparator(String input) {

        String separator = DEFAULT_SEPARATOR;

        if(isCustomDelimiter(input)) {
            String customDelimiter = getCustomDelimiter(input);
            return separator + MSG_OR + customDelimiter;
        }

        return separator;
    }

    private static boolean isCustomDelimiter(String input) {

        Matcher mach = CUSTOM_DELIMITER_PATTERN.matcher(input);

        return mach.find();
    }

    private static String getCustomDelimiter(String input) {
        String customDelimiter = "";

        Matcher mach = CUSTOM_DELIMITER_PATTERN.matcher(input);

        if(mach.find()) {
            customDelimiter = mach.group(FIRST_MATCHED);
        }

        return customDelimiter;
    }

    private static int startCalculator(String separator, String input) {

        int result = 0;

        String[] separatorResult = splitMethod(separator, input);

        validation(separatorResult);

        for(int i = 0; i < separatorResult.length; i++) {
            result += Integer.parseInt(separatorResult[i]);
        }

        return result;
    }

    private static String[] splitMethod(String separator, String input) {

        if(isCustomDelimiter(input)) {
            int index = input.indexOf(CUTTING_MSG);
            input = input.substring(index + 1);
        }

        return input.split(separator);
    }

    private static void validation(String[] separatorResult) {

        for(String result : separatorResult) {
            validMinusOrString(result);
        }
    }

    private static void validMinusOrString(String result) {

        for(char element : result.toCharArray()) {
            checkString(element);
        }

    }

    private static void checkString(char element) {
        if(!Character.isDigit(element)) {
            throw new IllegalArgumentException("숫자가 아닌 문자와 음수를 입력하시면 안됩니다!!!");
        }
    }

}
