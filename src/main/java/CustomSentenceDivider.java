import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomSentenceDivider {

    public static final Pattern PATTERN = Pattern.compile("//(.)\n(.*)");
    private final Matcher matcher;

    public CustomSentenceDivider(String sentence) {
        matcher = PATTERN.matcher(sentence);
    }

    public String getSplitter() {
        checkCustomExpression();

        return matcher.group(1);
    }

    public String getExpressionString() {
        checkCustomExpression();

        return matcher.group(2);
    }

    private void checkCustomExpression() {
        if (!isCustomExpression()) {
            throw new RuntimeException("커스텀 구분자 문자열이 아닙니다.");
        }
    }

    public boolean isCustomExpression() {
        return matcher.matches();
    }
}
