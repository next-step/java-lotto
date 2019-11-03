package step1.util;

import java.util.Arrays;
import java.util.List;

public class CustomParser extends ParseStrategy {
    private static final String PATTERN = "//(.)\n(.*)";
    private String customDelimiter;

    public CustomParser() {
        super.pattern = PATTERN;
    }

    @Override
    public List<String> parse() {
        this.customDelimiter = super.matcher.group(1);
        String customInput = super.matcher.group(2);
        return Arrays.asList(customInput.split(this.customDelimiter));
    }
}
