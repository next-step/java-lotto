package adder;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomTokenizeStrategy implements TokenizeStrategy {

    public static final String NO_MATCHER_FOUND = "문자열 내에 일치하는 패턴이 없습니다";
    public static final Pattern DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");

    private static final int DELIMITER_GROUP = 1;
    private static final int EXPRESSION_GROUP = 2;

    @Override
    public List<String> split(Expression expression) {
        return getSplitExpressions(expression.getMatchers(DELIMITER_PATTERN));
    }

    private List<String> getSplitExpressions(Matcher matcher) {
        validateMatcher(matcher);
        return new Expression(getNumbers(matcher))
                .split(getDelimiter(matcher));
    }

    private void validateMatcher(Matcher matcher) {
        if (!matcher.find()) {
            throw new IllegalArgumentException(NO_MATCHER_FOUND);
        }
    }

    private String getNumbers(Matcher matcher) {
        return matcher.group(EXPRESSION_GROUP);
    }

    private String getDelimiter(Matcher matcher) {
        return matcher.group(DELIMITER_GROUP);
    }

}
