import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Operator {
    private static final String DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER = "//(.)\n(.*)";

    public static String[] matchDelimiter(String text) {
        Matcher m = Pattern.compile(CUSTOM_DELIMITER).matcher(text);

        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens = m.group(2).split(customDelimiter);

            return tokens;
        }
        return text.split(DELIMITER);
    }
}
