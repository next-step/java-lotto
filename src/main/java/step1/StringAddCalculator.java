package step1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String DEFAULT_DELIMITER_REGEX = ",|:";
    private static final Pattern CUSTOM_DELIMITER_REGEX = Pattern.compile("//(.)\n(.*)");

    public static int splitAndSum(String inputStr) {
        if (inputStr == null || inputStr.isEmpty()) {
            return 0;
        }
        String[] tokens = splitToList(inputStr);
        int ret = 0;
        for (String token : tokens) {
            int i;
            try {
                i = Integer.parseInt(token);

            } catch (NumberFormatException e) {
                throw new RuntimeException("알맞은 문자열 포맷이 아닙니다.");
            }
            if (i < 0) {
                throw new RuntimeException("알맞은 문자열 포맷이 아닙니다.");

            }
            ret += i;
        }
        return ret;
    }

    private static String[] splitToList(String inputStr) {
        Matcher m = CUSTOM_DELIMITER_REGEX.matcher(inputStr);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
           return inputStr.split(DEFAULT_DELIMITER_REGEX);


    }

}