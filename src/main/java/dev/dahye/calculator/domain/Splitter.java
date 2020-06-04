package dev.dahye.calculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Splitter {
    private static final String DEFAULT_DELIMITER = "[,:]";
    private static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";
    private static final Pattern PATTERN = Pattern.compile(CUSTOM_DELIMITER_REGEX);
    private static final int GROUP_BY_DELIMITER = 1;
    private static final int GROUP_BY_INPUT = 2;
    private final String target;
    private final String delimiter;

    private Splitter(String target, String delimiter) {
        this.target = target;
        this.delimiter = delimiter;
    }

    public static Splitter init(final String target) {
        Matcher m = PATTERN.matcher(target);

        if (m.matches()) {
            return setByCustomDelimiter(m);
        }

        return setByDefaultDelimiter(target);
    }

    private static Splitter setByCustomDelimiter(Matcher m) {
        String delimiter = m.group(GROUP_BY_DELIMITER);
        String input = m.group(GROUP_BY_INPUT);

        return new Splitter(input, delimiter);
    }

    private static Splitter setByDefaultDelimiter(String input) {
        return new Splitter(input, DEFAULT_DELIMITER);
    }

    public List<String> split() {
        return Arrays.asList(this.target.split(this.delimiter));
    }
}
