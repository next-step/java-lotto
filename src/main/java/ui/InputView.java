package ui;

import domain.Number;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputView {
    private final static String DEFAULT_DIVIDER_HEADER = "[,";
    private final static String DEFAULT_DIVIDER_TAIL = ":]";
    private final static String NULL_OR_EMPTY_INPUT_VALUE = "0";
    private final static int REGEX_CUSTOM_DIVIDER_GROUP = 1;
    private final static int REGEX_TARGET_STRING_GROUP = 2;

    private String divider;
    private String targetString;

    private InputView(String divider, String targetString) {
        this.divider = divider;
        this.targetString = targetString;
    }

    public static InputView create(String input) {
        if (input == null) {
            return new InputView(DEFAULT_DIVIDER_HEADER + DEFAULT_DIVIDER_TAIL, NULL_OR_EMPTY_INPUT_VALUE);
        }
        if (input.trim().isEmpty()) {
            return new InputView(DEFAULT_DIVIDER_HEADER + DEFAULT_DIVIDER_TAIL, NULL_OR_EMPTY_INPUT_VALUE);
        }

        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (matcher.find()) {
            String divider = DEFAULT_DIVIDER_HEADER +
                    matcher.group(REGEX_CUSTOM_DIVIDER_GROUP) +
                    DEFAULT_DIVIDER_TAIL;
            return new InputView(divider, matcher.group(REGEX_TARGET_STRING_GROUP));
        }

        return new InputView(DEFAULT_DIVIDER_HEADER + DEFAULT_DIVIDER_TAIL, input);
    }

    public List<Number> extractNumbers() {
        return Arrays.stream(this.targetString.split(divider))
                .map(Number::new)
                .collect(Collectors.toList());
    }

    public String getDivider() {
        return divider;
    }

    public String getTargetString() {
        return targetString;
    }
}
