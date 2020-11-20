package step01;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tokenizer {
    private static String PATTERN = "//(.)\n(.*)";
    private static int DELIMITER = 1;
    private static int CONTENTS = 2;
    private static String TOKENS = ",|:";

    private static String[] split(String text, String delimiter) {
        return text.split(delimiter);
    }

    public static String[] execute(String text) {
        Matcher matcher = Pattern.compile(PATTERN).matcher(text);

        if (matcher.find()) {
            return split(matcher.group(CONTENTS), matcher.group(DELIMITER));
        }
        return split(text, TOKENS);
    }
}
