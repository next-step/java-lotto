package stringpluscalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class StringPlusCalculator {
    private static String defaultDelimiter = ",|:";
    private static String customDelimiterRgexString = "//(.*)\n(.*)";

    protected int addByCommaOrColon(String str) {
        return addStringNumbers(str.split(defaultDelimiter));
    }

    protected boolean checkCustomDelimiter(String str) {
        return getCustomMatcher(str).find();
    }

    private static Matcher getCustomMatcher(String str) {
        return Pattern.compile(customDelimiterRgexString).matcher(str);
    }

    protected int addByCustomDelimiter(String str) {
        Matcher matcher = getCustomMatcher(str);
        matcher.find();
        return addStringNumbers(matcher.group(2).split(matcher.group(1)));
    }

    protected int addByDelimiter(String str) {
        if (checkCustomDelimiter(str)) {
            return addByCustomDelimiter(str);
        }
        return addByCommaOrColon(str);
    }

    private int addStringNumbers(String[] split) {
        List<Number> numberList = new ArrayList<>();
        for (String string : split) numberList.add(new Number(string));
        return Stream.of(split).mapToInt(Integer::parseInt).sum();
    }
}
