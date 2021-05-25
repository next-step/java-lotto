package lotto.tool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import lotto.exceptions.InvalidPatternException;

public final class Tokenizer {

    /*
        입력 가능한 패턴:
        - 1
        - 1,2:3
        - //;\n1,2:3;4

        그룹 캡쳐:
        1. 구분자
        2. 숫자 목록
     */
    private static final Pattern PRECOMPILED_PATTERN = Pattern.compile(
        "^(?://([^\\d\\n\\r])\\\\n)*(\\d+(?:(?:(?:\\1)|(?:[,:]))(?:\\d+))*)$");
    private static final int DELIMITER_POSITION = 1;
    private static final int NUMBERS_POSITION = 2;

    private static final List<String> DELIMITERS = Arrays.asList(",", ":");
    private static final String OR = "|";
    private static final String ESCAPED = "\\%s";

    private Tokenizer() {
    }

    public static boolean isEmpty(String text) {
        return text == null || text.isEmpty();
    }

    public static List<String> captureNumbers(String text) {
        Matcher matcher = PRECOMPILED_PATTERN.matcher(text);
        if (matcher.find()) {
            String customDelimiter = matcher.group(DELIMITER_POSITION);
            return tokenize(matcher.group(NUMBERS_POSITION), customDelimiter);
        }
        throw new InvalidPatternException();
    }

    private static String loadDelimiters(String text) {
        List<String> delimiters = new ArrayList<>(DELIMITERS);
        if (!isEmpty(text)) {
            delimiters.add(text);
        }
        return String.join(OR, delimiters);
    }

    private static List<String> tokenize(String text, String customDelimiter) {
        String[] tokens;
        try {
            tokens = text.split(loadDelimiters(customDelimiter));
        } catch (PatternSyntaxException e) {
            tokens = text.split(loadDelimiters(escape(customDelimiter)));
        }
        return Arrays.asList(tokens);
    }

    private static String escape(String delimiter) {
        return String.format(ESCAPED, delimiter);
    }
}
