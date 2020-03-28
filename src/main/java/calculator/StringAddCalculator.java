package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String DEFAULT_DELIMITERS = "[,:]";
    private static final String CUSTOM_DELIMITER_REGEX = "//(.)#(.*)";
    private static final Pattern CUSTOM_PATTERN = Pattern.compile(CUSTOM_DELIMITER_REGEX);

    public static int calculate(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        Matcher custom = CUSTOM_PATTERN.matcher(input);
        if (custom.find()) {
            return new CustomNumbers(custom.group(2).split(custom.group(1))).sum();
        }

        return new CustomNumbers(input.split(DEFAULT_DELIMITERS)).sum();
    }
}
