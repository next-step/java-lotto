import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Splitter {

    public static final Pattern CUSTOM_DELIMITER = Pattern.compile("//(.)\n(.*)");
    public static final String DEFAULT_DELIMITER = ",|:";

    private Splitter() {}
    
    public static String[] splitToTokens(String value) {
        Matcher m = CUSTOM_DELIMITER.matcher(value);
        if (m.find( )) {
            String customDelimiter = m.group(1);
            String[] tokens = m.group(2).split(customDelimiter);
            return tokens;
        }
        return value.split(DEFAULT_DELIMITER);
    }
}
