package stringaddcalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Input {
    private static final String DEFAULT_DELIMITER = ",";
    private static final String CUSTOM_DELIMITER_PATTERN = "^//(.)\n";

    private String delimiter;
    private String numbers;
    private Operands operands;

    public Input(String input) {
        input = correctZeroLikeString(input);
        parse(input);
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

    private void parse(String input) {
        delimiter = DEFAULT_DELIMITER;
        numbers = input;

        Matcher delimiterMatcher = Pattern.compile(CUSTOM_DELIMITER_PATTERN).matcher(input);
        if (delimiterMatcher.find()) {
            delimiter = delimiterMatcher.group(1);
            numbers = deleteCustomDelimiter(delimiterMatcher);
        }
    }

    private String deleteCustomDelimiter(Matcher delimiterMatcher) {
        StringBuffer builder = new StringBuffer();
        delimiterMatcher.appendReplacement(builder, "");
        delimiterMatcher.appendTail(builder);
        return builder.toString();
    }
}
