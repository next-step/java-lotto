package step1.utils;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SplitAndSum {

    public static final String DELIMETER = ",|:";
    public static final String CUSTOM_DELIMETER = "//(.)\n(.*)";

    public static int splitAndSum(String string) {
        return getSum(StringSpliter.spliter(DELIMETER, string));
    }

    public static int splitAndSUmWithCustomDelimiter(String string) {
        Matcher matcher = Pattern.compile(CUSTOM_DELIMETER).matcher(string);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            String[] tokens = StringSpliter.spliter(customDelimiter, matcher.group(2));
            return getSum(tokens);
        }
        return 0;
    }

    private static int getSum(String[] tokens) {
        return Arrays.stream(tokens).mapToInt(Integer::parseInt).sum();
    }
}
