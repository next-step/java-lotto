package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Delimiter {
    private Delimiter() {
    }

    private static final Pattern pattern = Pattern.compile("//(.)\n(.*)");
    public static final String DEFAULT_REGEX = "[,:]";

    public static Numbers split(String input) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            return splitCustom(matcher);
        }
        return splitDefault(input);
    }

    private static Numbers splitDefault(String input) {
        String[] tokens = input.split(DEFAULT_REGEX);

        return new Numbers(Arrays.stream(tokens)
                .map(it -> new PositiveNumber(Integer.parseInt(it)))
                .collect(Collectors.toList()));
    }

    private static Numbers splitCustom(Matcher matcher) {
        String customDelimiter = matcher.group(1);
        String[] tokens = matcher.group(2)
                .split(customDelimiter);

        return new Numbers(Arrays.stream(tokens)
                .map(it -> new PositiveNumber(Integer.parseInt(it)))
                .collect(Collectors.toList()));
    }
}
