import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomSplitterDivider {

    public static final Pattern PATTERN = Pattern.compile("//(.)\n(.*)");

    public static String extractSplitter(String input) {
        Matcher matcher = PATTERN.matcher(input);
        matcher.find();
        return matcher.group(1);
    }

    public static String extractExpression(String input) {
        Matcher matcher = PATTERN.matcher(input);
        matcher.find();
        return matcher.group(2);
    }
}
