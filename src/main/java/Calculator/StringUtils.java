package Calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

    private static String PATTERN = "//(.)\n(.*)";
    private static String DEFAULT_DELIMETER = ",|:";

    public static boolean checkEmpty(String input) {
        if (input == null || input.isEmpty() || input.equals("")) {
            return true;
        }
        return false;
    }

    public static String[] splitWithMatcher(String input) {
        Matcher m = Pattern.compile(PATTERN).matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return input.split(DEFAULT_DELIMETER);
    }

    public static int[] parseOperand(String[] strOperands) {
        return Arrays.stream(strOperands)
                .mapToInt(Integer::parseInt)
                .toArray();
    }

}
