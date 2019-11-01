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
    public List<String> parse() {
        return Arrays.asList(super.matcher.group(1).split(DELIMITER));
    }

}
