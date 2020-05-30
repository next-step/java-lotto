import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {
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

    private static Matcher findSplitKey(String text) {
        return Pattern.compile("//(.)\n(.*)").matcher(text);
    }
}
