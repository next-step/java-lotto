package calculator.domain.splitter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomSplitter implements Splitter {
    private static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";
    private static final Pattern pattern = Pattern.compile(CUSTOM_DELIMITER_REGEX);

    @Override
    public boolean isSupport(String input) {
        return pattern.matcher(input).matches();
    }

    @Override
    public String[] split(String input) {
        Matcher matcher = pattern.matcher(input);
        matcher.find();

        String customDelimiter = matcher.group(1);
        return matcher.group(2).split(customDelimiter);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
