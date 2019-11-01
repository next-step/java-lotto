package util;

import java.util.Arrays;
import java.util.List;

public class DefaultParser extends ParseStrategy {
    private static final String PATTERN = "(.*)";
    private static final String DELIMITER = "[:,]";

    public DefaultParser() {
        super.pattern = PATTERN;
    }

    @Override
    protected List<String> parse(String input) {
        return Arrays.asList(input.split(DELIMITER));
    }

}
