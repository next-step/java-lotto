package StringCalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSplitter {

    public final static String DEFAULT_TOKENIZER = ",|:";
    public final static String CUSTOM_TOKENIZER = "//(.)\n(.*)";

    private StringSplitter() { }

    public static Matcher getMatcher(String value) {
        return Pattern.compile(CUSTOM_TOKENIZER).matcher(value);
    }

    public static String[] getStrings(String value) {
        Matcher matcher = getMatcher(value);
        if (matcher.find()) {
            return matcher.group(2).split(matcher.group(1));
        }
        return value.split(DEFAULT_TOKENIZER);
    }
}
