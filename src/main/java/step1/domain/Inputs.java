package step1.domain;

import step1.constants.Constants;
import step1.utils.StringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Inputs {
    private static final Pattern pattern = Pattern.compile(Constants.CUSTOM_SEPARATOR_PATTERN);

    private final List<String> inputs;

    private Inputs(List<String> inputs) {
        this.inputs = inputs;
    }

    public static Inputs from(final String inputs) {
        return new Inputs(getInputs(inputs));
    }

    private static List<String> getInputs(final String input) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            return customSplit(matcher);
        }
        return defaultSplit(input);
    }

    private static List<String> customSplit(Matcher matcher) {
        return Arrays.asList(StringUtils.split(matcher.group(2), matcher.group(1)));
    }

    private static List<String> defaultSplit(final String input) {
        return Arrays.asList(StringUtils.split(input, Constants.SEPARATOR_PATTERN));
    }

    public List<String> getInputs() {
        return Collections.unmodifiableList(inputs);
    }
}
