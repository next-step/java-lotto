package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSplitter implements Splitter {

    private static final Pattern pattern = Pattern.compile("//(.)\n(.*)");

    @SuppressWarnings("RegExpSingleCharAlternation")
    private static final String DEFAULT_REGEX = ",|:";
    private static final String DELIMITER = "|";

    @Override
    public String[] split(String input) {
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            return addRegexAndSplit(matcher);
        }

        return input.split(DEFAULT_REGEX);
    }

    private String[] addRegexAndSplit(Matcher matcher) {
        String customRegex = String.join(DELIMITER, DEFAULT_REGEX, matcher.group(1));

        return matcher.group(2).split(customRegex);
    }

}
