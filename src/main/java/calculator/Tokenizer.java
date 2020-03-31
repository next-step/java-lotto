package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tokenizer {

    private static final String DELIMITERS = ",|:";
    private static final Pattern pattern = Pattern.compile("//(.)\n(.*)");

    private Tokenizer() {}

    public static String[] split(String text) {
        String delimiter = DELIMITERS;
        Matcher matcher = pattern.matcher(text);

        if(matcher.find()) {
            String customDelimiter = matcher.group(1);
            text = matcher.group(2);
            delimiter = delimiter + "|" + customDelimiter;
        }

        return text.split(delimiter);
    }
}
