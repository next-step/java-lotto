import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Splitter {

    public static String[] splitToTokens(String value) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(value);
        if (m.find( )) {
            String customDelimiter = m.group(1);
            String[] tokens = m.group(2).split(customDelimiter);
            return tokens;
        }
        return null;
    }
}
