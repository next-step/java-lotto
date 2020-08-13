package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SplitUtil {
    public static final String SPLIT_DELIMITER = "[,:]";
    public static final Pattern CUSTOM_DELIMITER = Pattern.compile("//(.)\\n(.*)");

    private SplitUtil() {
    }

    public static String[] splitExpression(String expression) {
        Matcher matcher = CUSTOM_DELIMITER.matcher(expression);

        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }

        return expression.split(SPLIT_DELIMITER);
    }
}
