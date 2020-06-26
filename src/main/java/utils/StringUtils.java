package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {
    private static final Pattern patternKey = Pattern.compile("//(.)\n(.*)");

    public static String[] splitString(String text) {
        String key = ",|:";
        Matcher m = findSplitKey(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            key += "|";
            key += customDelimiter;
            return m.group(2).split(key);
        }
        return text.split(key);
    }

    public static String removeWhiteSpace(String text) {
        return text.replace(" ", "");
    }

    private static Matcher findSplitKey(String text) {
        return patternKey.matcher(text);
    }
}
