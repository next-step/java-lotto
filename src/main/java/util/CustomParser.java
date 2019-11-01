package util;

import java.util.Arrays;
import java.util.List;

public class CustomParser extends ParseStrategy {
    private static final String PATTERN = "//(.)\n(.*)";
    private String customDelimiter;

    public CustomParser() {
        super.pattern = PATTERN;
    }

    @Override
    protected List<String> parse(String input) {
        this.customDelimiter = super.matcher.group(1);
        String customInput = super.matcher.group(2);
        return Arrays.asList(customInput.split(this.customDelimiter));
    }
}
