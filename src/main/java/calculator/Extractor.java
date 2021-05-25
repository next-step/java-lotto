package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Extractor {

    public static final String DEFAULT_DELIMITER_REGEX = "[,:]";
    public static final Pattern CUSTOM_DELIMITER_REGEX_PATTERN = Pattern.compile("//(.)\n(.*)");
    public static final int OPERAND_POSITION = 2;
    public static final int CUSTOM_DELIMITER_POSITION = 1;

    private final String input;

    public Extractor(String input) {
        this.input = input;
    }

    public String[] extractOperands() {
        Matcher matcher = CUSTOM_DELIMITER_REGEX_PATTERN.matcher(this.input);

        if (matcher.find()) {
            String customDelimiter = extractCustomDelimiter(matcher);
            return extractOperands(matcher).split(customDelimiter);
        }

        return splitOperandsByDefaultDelimiter(this.input);
    }

    private String extractCustomDelimiter(Matcher matcher) {
        return matcher.group(CUSTOM_DELIMITER_POSITION);
    }

    private String extractOperands(Matcher matcher) {
        return matcher.group(OPERAND_POSITION);
    }

    private String[] splitOperandsByDefaultDelimiter(String input) {
        return input.split(DEFAULT_DELIMITER_REGEX);
    }
}

