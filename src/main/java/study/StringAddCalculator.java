package study;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static final String DEFAULT_DELIMETER_VALUE = ",|:";
    public static final String CUSTOM_DELIMETER_VALUE = "//(.)\n(.*)";
    public static final String NUMBER_REGEX = "[+-]?[0-9]+$";

    public static final int DEFAULT_RESULT_NUM = 0;
    public static final int MATCHER_GROUP_1 = 1;
    public static final int MATCHER_GROUP_2 = 2;

    public static final String ILLEGAL_ARGUMENT_EXECEPTION_MSG = "양수만 입력 가능합니다.";
    public static final String NUMBER_FORMAT_EXECEPTION_MSG = "숫자만 입력 가능합니다.";

    public static int splitAndSum(String text) {
        if(checkNullAndEmpty(text))
            return DEFAULT_RESULT_NUM;
        return sumInteger(seperateText(text));
    }

    private static int sumInteger(String[] seperateText) {
        int sum = 0;
        Arrays.asList(seperateText).forEach(checkText -> checkTextValidation(checkText));
        for (String intText : seperateText) {
            sum += Integer.parseInt(intText);
        }
        return sum;
    }

    private static void checkTextValidation(String checkText) {
        if(!checkText.matches(NUMBER_REGEX)) {
            throw new NumberFormatException(NUMBER_FORMAT_EXECEPTION_MSG);
        }
        if(Integer.parseInt(checkText) < 0 ) {
            throw new IllegalArgumentException (ILLEGAL_ARGUMENT_EXECEPTION_MSG);
        }
    }

    private static String[] seperateText(String text) {
        String[] seperateText = splitCustomDelimiter(text);
        if(seperateText != null)
            return seperateText;
        return splitDefaultDelimeter(text);
    }

    private static String[] splitCustomDelimiter(String text) {
        Matcher matcher = Pattern.compile(CUSTOM_DELIMETER_VALUE).matcher(text);
        if(matcher.find()) {
            String customDelimiter = matcher.group(MATCHER_GROUP_1);
            return matcher.group(MATCHER_GROUP_2).split(customDelimiter);
        }
        return null;
    }

    private static String[] splitDefaultDelimeter(String text) {
        return text.split(DEFAULT_DELIMETER_VALUE);
    }

    private static boolean checkNullAndEmpty(String text) {
        if(text == null || text.isEmpty())
            return true;
        return false;
    }
}
