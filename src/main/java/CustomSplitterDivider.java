import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomSplitterDivider {

    public static final Pattern PATTERN = Pattern.compile("//(.)\n(.*)");

    public static String extractSplitter(String input) {
        Matcher matcher = PATTERN.matcher(input);
        matcher.find();
        return matcher.group(1);
    }

    public static String extractExpressionString(String input) {
        Matcher matcher = PATTERN.matcher(input);
        matcher.find();
        return matcher.group(2);
    }

    public static boolean isCustomExpression(String input) {
        Matcher matcher = PATTERN.matcher(input);
        return matcher.find();
    }
}
