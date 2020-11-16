package step01;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tokenizer {
    private static int DELIMITER = 1;
    private static int CONTENTS = 2;
    private static String TOKENS = ",|:";

    public static String[] execute(String text) {
        return text.split(TOKENS);
    }

    public static String[] executeByDelimiter(String text, String delimiter) {
        return text.split(delimiter);
    }

    public static String[] executeByPattern(String text, String pattern) {
        Matcher matcher = Pattern.compile(pattern).matcher(text);

        if (matcher.find()) {
            return executeByDelimiter(matcher.group(CONTENTS), matcher.group(DELIMITER));
        }
        return execute(text);
    }
}
