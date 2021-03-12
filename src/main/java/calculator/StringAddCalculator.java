package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private int result;

    public int splitAndSum(String text) {

        if (Validator.isBlankOrEmpty(text)) {
            return Constants.ZERO;
        }

        if (Validator.isOnlyOneNumber(text)) {
           return Integer.parseInt(text);
        }

        return calculate(text);
    }

    private int calculate(String text) {
        String[] splitNumber = splitNumber(text);

        for (int i = 0; i< splitNumber.length; i++) {
            Validator.isLessThenZero(splitNumber[i]);
            result += Integer.parseInt(splitNumber[i]);
        }

        return result;
    }

    private String[] splitNumber(String text) {
        Matcher m = Pattern.compile(Constants.REGEX_CUSTOM_DELIMITER).matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(Constants.POSITION_OF_CUSTOM_DELIMITER);
            return m.group(Constants.POSITION_OF_TEXT).split(customDelimiter);
        }

        return text.split(Constants.REGEX_BASIC_DELIMITER);
    }


}
