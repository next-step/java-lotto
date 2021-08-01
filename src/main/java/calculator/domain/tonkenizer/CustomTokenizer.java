package calculator.domain.tonkenizer;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomTokenizer implements Tokenizer {
    private static final String REGEX = "//(.)\n(.*)";
    private static final Pattern PATTERN = Pattern.compile(REGEX);
    private static final int DELIMITER_INDEX = 1;
    private static final int NUMBER_INDEX = 2;

    @Override
    public String[] split(String input) {
        Matcher matcher = validate(createMatcher(input));
        return matcher.group(NUMBER_INDEX).split(matcher.group(DELIMITER_INDEX));
    }

    private static Matcher createMatcher(String input) {
        return PATTERN.matcher(input);
    }

    private Matcher validate(Matcher matcher) {
        if (isNotFound(matcher)) {
            throw new IllegalStateException("형식에 맞는 케이스를 찾지 못했습니다.");
        }

        return matcher;
    }

    private boolean isNotFound(Matcher matcher) {
        return !matcher.find();
    }

    public static boolean isCustomExpression(String input) {
        return createMatcher(input).matches();
    }

}
