package lotto.step1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private static final Pattern CUSTOM = Pattern.compile("//(.)\n(.*)");
    private static final Pattern BASIC = Pattern.compile("[,:]");

    public static int addString(String s) {
        return checkNullOrEmpty(s) ? 0 : sum(splitValue(s));
    }

    public static boolean checkNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }

    public static String[] splitValue(String input) {
        return isCustom(input) ? splitCustomPattern(input) : input.split(BASIC.toString());
    }

    public static int sum(String[] input) {
        int sum = 0;
        for (String s : input) {
            checkMinusOrNotNumber(s);
            sum += Integer.valueOf(s);
        }
        return sum;
    }

    public static void checkMinusOrNotNumber(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                throw new RuntimeException();
            }
        }
    }

    static boolean isCustom(String input) {
        return CUSTOM.matcher(input).matches();
    }

    public static String[] splitCustomPattern(String input) {
        Matcher matcher = CUSTOM.matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }
        return null;
    }

}
