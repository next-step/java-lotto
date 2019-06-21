package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.stream.Collectors.toList;

public class Expression {

    private static final Pattern CUSTOM_PATTERN_DELIMITER = Pattern.compile("//(.)\n(.*)");
    private static final String PREFIX_CUSTOM_HAS_DELIMITER = "//";
    static final String DEFAULT_DELIMITER = "[:,]";

    private String delimiter;
    private String tokens;

    public Expression(String delimiter, String tokens) {
        this.delimiter = delimiter;
        this.tokens = tokens;
    }

    public static Expression from(String inputOfString) {
        if (hasCustomDelimiter(inputOfString)) {
            Matcher customMatcher = CUSTOM_PATTERN_DELIMITER.matcher(inputOfString);
            if (customMatcher.find()) {
                return new Expression(customMatcher.group(1), customMatcher.group(2));
            }
        }
        return new Expression(DEFAULT_DELIMITER, inputOfString);
    }

    private static boolean hasCustomDelimiter(String inputOfString) {
        return inputOfString.startsWith(PREFIX_CUSTOM_HAS_DELIMITER);
    }

    public void checkTokens() {
        Pattern compile = Pattern.compile("^\\d+((" + delimiter + ")\\d+)*$");
        if(!compile.matcher(tokens).matches()){
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

    public String getDelimiter() {
        return delimiter;
    }

    public String getTokens() {
        return tokens;
    }

    public List<Integer> numbers() {
        return parseIntArray(tokens.split(delimiter));
    }

    private static List<Integer> parseIntArray(String[] numbersOfString) {
        return Arrays.stream(numbersOfString)
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(toList());
    }
}
