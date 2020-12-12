package step1.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputString {

    private static final String DEFAULT_DELIMITER = ",|:";
    private static final Pattern CUSTOM_PATTERN = Pattern.compile("//(.)\\\\n(.*)");

    private String input;
    private String delimiter;

    public InputString(String input) {
        this.input = checkedInput(input);
        this.delimiter = DEFAULT_DELIMITER;
    }

    public String[] split() {
        Matcher matcher = CUSTOM_PATTERN.matcher(input);

        if (matcher.find()) {
            delimiter = matcher.group(1);
            input = matcher.group(2);
        }

        return input.split(delimiter);
    }

    private String checkedInput(String input) {
        if (input == null || input.trim().isEmpty()) input= "0";
        return input;
    }

    public String getInput() {
        return input;
    }
}
