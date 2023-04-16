package step1;

import util.CalculatorValidator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private final String COMMA_COLON_DELIMITER = ",|:";
    private final String CUSTOM_DELIMITER = "//(.)\n(.*)";
    private final String NUMBER_REGULAR = "^[0-9]+$";
    private final String CHECK_CUSTOM_DELIMITER = "//";

    public int calculate(String text) {
        if(checkNullString(text) || checkEmptyString(text)) {
            return 0;
        }

        if(checkOnlyOneText(text)) {
            CalculatorValidator.validate(text);
            return Integer.parseInt(text);
        }

        if(checkCustomDelimiter(text)) {
            return sumCustomDelimiter(text);
        }

        return sum(text.split(COMMA_COLON_DELIMITER));
    }

    private int sumCustomDelimiter(String text) {
        Matcher m = Pattern.compile(CUSTOM_DELIMITER).matcher(text);
        String[] tokens = {""};
        if (m.find()) {
            String customDelimiter = m.group(1);
            tokens = m.group(2).split(customDelimiter);
        }
        return sum(tokens);
    }

    private boolean checkCustomDelimiter(String text) {
        return text.startsWith(CHECK_CUSTOM_DELIMITER);
    }

    private int sum(String[] texts) {
        return Arrays.stream(texts)
                .mapToInt(text -> {
                    CalculatorValidator.validate(text);
                    return Integer.parseInt(text);
                })
                .sum();

    }

    private boolean checkOnlyOneText(String text) {
        Matcher m = Pattern.compile(NUMBER_REGULAR).matcher(text);
        return m.find();
    }

    private boolean checkEmptyString(String text) {
        return text.isEmpty();
    }

    private boolean checkNullString(String text) {
        return text == null;
    }

}
