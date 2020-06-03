package calcurator;

import java.util.regex.Matcher;

public class Splitter {
    public static String[] split(String input) {
        Matcher matcher = Const.CUSTOM_PATTERN.matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(Const.PATTERN_SEPARATOR_INDEX);
            return matcher.group(Const.PATTERN_SEPARATOR_INPUTS).split(customDelimiter);
        }
        return input.split(Const.SYMBOL_COMMA_AND_COLON);
    }
}
