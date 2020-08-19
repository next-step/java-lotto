package step1.utils;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SplitAndSum {

    public static final int GROUP_1 = 1;
    public static final int GROUP_2 = 2;

    private SplitAndSum() { }

    public static int splitAndSUmWithCustomDelimiter(String string) {
        Matcher matcher = Pattern.compile(Delimeter.CUSTOM_DELIMETER).matcher(string);

        if (matcher.find()) {
            String customDelimiter = matcher.group(GROUP_1);
            String[] tokens = StringSpliter.spliter(customDelimiter, matcher.group(GROUP_2));
            return getSum(tokens);
        }

        return getSum(StringSpliter.spliter(Delimeter.DELIMETER, string));
    }

    private static int getSum(String[] tokens) {
        return Arrays.stream(tokens).mapToInt(Integer::parseInt).sum();
    }
}
