package StringAddCalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Input {
    private static final String DEFAULT_DELIMITER = ",";
    private static final String CUSTOM_DELIMITER_PATTERN = "^//(.)\n";

    private String input;
    private Operands operands;

    public Input(String input) {
        this.input = correctZeroLikeString(input);
        String delimiter = parseDelimiter();
        String numbers = parseNumber();
        this.operands = new Operands(numbers.split(delimiter));
    }

    public Operands getOperands() {
        return this.operands;
    }

    private String correctZeroLikeString(String input) {
        if (input == null || input.length() == 0) {
            input = "0";
        }
        return input;
    }

    private String parseDelimiter() {
        String delimiter = DEFAULT_DELIMITER;
        Matcher delimiterMatcher = Pattern.compile(CUSTOM_DELIMITER_PATTERN).matcher(input);
        if (delimiterMatcher.find()) {
            delimiter = delimiterMatcher.group(1);
            input = deleteCustomDelimiter(delimiterMatcher);
        }
        return delimiter;
    }

    private String parseNumber() {
        String numbers = input;
        return numbers;
    }

    private String deleteCustomDelimiter(Matcher delimiterMatcher) {
        StringBuffer builder = new StringBuffer();
        delimiterMatcher.appendReplacement(builder, "");
        delimiterMatcher.appendTail(builder);
        return builder.toString();
    }
}
