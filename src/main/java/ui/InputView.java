package ui;

import domain.Number;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputView {
    private final static String DEFAULT_DIVIDER = "[,:]";

    private String divider;
    private String targetString;

    private InputView(String divider, String targetString) {
        this.divider = divider;
        this.targetString = targetString;
    }

    public static InputView create(String input) {
        if (input == null) return new InputView(DEFAULT_DIVIDER, "0");
        if (input.trim().isEmpty()) return new InputView(DEFAULT_DIVIDER, "0");

        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (matcher.find()) {
            String divider = "[," + matcher.group(1) + ":]";
            return new InputView(divider, matcher.group(2));
        }

        return new InputView(DEFAULT_DIVIDER, input);
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
