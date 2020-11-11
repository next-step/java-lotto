import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomSplitterDivider {

    public static final Pattern PATTERN = Pattern.compile("//(.)\n(.*)");
    private final Matcher matcher;

    public CustomSplitterDivider(String input) {
        matcher = PATTERN.matcher(input);
    }

    public String extractSplitter() {
        return matcher.group(1);
    }

    public String extractExpressionString() {
        return matcher.group(2);
    }

    public boolean isCustomExpression() {
        return matcher.find();
    }
}
