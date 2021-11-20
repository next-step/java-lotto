package lotto.step1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private StringAddCalculator() {
        throw new AssertionError();
    }

    public static int splitAndSum(String input) {

        if(input == null || "".equals(input.trim())) {
            return 0;
        }

        int result = 0;

        String separator = createSeparator(input);
        result = startCalculator(separator, input);

        return result;
    }

    private static String createSeparator(String input) {

        String separator = ",|:";

        if(isCustomDelimiter(input)) {
            String customDelimiter = getCustomDelimiter(input);
            separator += "|" + customDelimiter;
        }

        return separator;
    }

    private static boolean isCustomDelimiter(String input) {

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);

        return m.find();
    }

    private static String getCustomDelimiter(String input) {
        String customDelimiter = "";

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);

        if(m.find()) {
            customDelimiter = m.group(1);
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
            int index = input.indexOf("\n");
            input = input.substring(index + 1);
        }

        return input.split(separator);
    }

    private static void validation(String[] separatorResult) {

        for(String tt : separatorResult) {
            validMinusOrString(tt);
        }
    }

    private static void validMinusOrString(String tt) {

        for(char c : tt.toCharArray()) {
            checkString(c);
        }

    }

    private static void checkString(char c) {
        if(!Character.isDigit(c)) {
            throw new RuntimeException("숫자가 아닌 문자와 음수를 입력하시면 안됩니다!!!");
        }
    }

}
