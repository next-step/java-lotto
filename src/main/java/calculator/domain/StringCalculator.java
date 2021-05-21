package calculator.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private final String DEFAULT_DELIMITER = ":|,";
    private final String DEFAULT_REGEX_PATTERN = "//(.)\n(.*)";
    private final int DELIMITER_SECTION = 1;
    private final int NUMBERS_SECTION = 2;

    public StringCalculator() { }

    public int calculate(String inputString) {
        if (isNullOrEmpty(inputString)) {
            return 0;
        }
        Numbers numbers = makeNumbersUsing(inputString);

        return numbers.sum();
    }

    public Numbers makeNumbersUsing(String inputString) {
        Matcher m = Pattern.compile(DEFAULT_REGEX_PATTERN).matcher(inputString);
        if (m.find()) {
            new Numbers(m.group(NUMBERS_SECTION).split(m.group(DELIMITER_SECTION)));
        }

        return new Numbers(inputString.split(DEFAULT_DELIMITER));
    }

    protected boolean isNullOrEmpty(String numberString) {
        return (numberString == null || numberString.equals(""));
    }

}
