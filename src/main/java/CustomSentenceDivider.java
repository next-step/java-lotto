import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomSentenceDivider {

    public static final Pattern PATTERN = Pattern.compile("//(.)\n(.*)");
    private final Matcher matcher;

    public CustomSentenceDivider(String sentence) {
        matcher = PATTERN.matcher(sentence);
    }

    public String getSplitter() {
        if (!isCustomExpression()) {
            return null;
        }

        return matcher.group(1);
    }

    public String getExpressionString() {
        if (!isCustomExpression()) {
            return null;
        }

        return matcher.group(2);
    }

    public boolean isCustomExpression() {
        return matcher.matches();
    }
}
