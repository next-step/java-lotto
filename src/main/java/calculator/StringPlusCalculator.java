package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringPlusCalculator {

    private StringPlusCalculator() {}

    private static final String DEFAULT_DELIMITERS = "[,:]";
    private static final String CUSTOM_DELIMITER_REGEX = "//(.)\\\\n(.*)";

    public static int calculate(String input) {
        if (isEmpty(input)) {
            return 0;
        }

        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_REGEX)
                                 .matcher(input);

        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            String customInput = matcher.group(2);

            return new NatualNumPlusFormula(customInput.split(customDelimiter)).sum();
        }

        return new NatualNumPlusFormula(input.split(DEFAULT_DELIMITERS)).sum();
    }

    private static boolean isEmpty(String input) {
        return input == null || input.isEmpty();
    }
}
