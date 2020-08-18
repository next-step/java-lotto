package step1.utils;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SplitAndSum {

    public static int splitAndSUmWithCustomDelimiter(String string) {
        Matcher matcher = Pattern.compile(Delimeter.CUSTOM_DELIMETER).matcher(string);

        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            String[] tokens = StringSpliter.spliter(customDelimiter, matcher.group(2));
            return getSum(tokens);
        }

        return getSum(StringSpliter.spliter(Delimeter.DELIMETER, string));
    }

    private static int getSum(String[] tokens) {
        return Arrays.stream(tokens).mapToInt(Integer::parseInt).sum();
    }
}
