package step1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSumCalculator {

    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER = "//(.)\n(.*)";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile(CUSTOM_DELIMITER);
    private static final int NUMBER_RETURNED_WHEN_EMPTY_OR_NULL = 0;
    private static final String MINUS_NUMBER_EXCEPTION_MESSAGE = "음수는 입력할 수 없습니다.";

    public int sum(final String inputText) {
        if (validationInputText(inputText)) {
            return NUMBER_RETURNED_WHEN_EMPTY_OR_NULL;
        }
        return splitAndSum(inputText);
    }

    private boolean validationInputText(String inputText) {
        return inputText == null || inputText.trim().isEmpty();
    }

    private int splitAndSum(final String inputText) {

        String[] inputNumbers = splitInputText(inputText);
        int result = 0;
        for (String inputNumber : inputNumbers) {
            result += getParseInt(inputNumber);
        }
        return result;
    }

    private String[] splitInputText(String inputText) {

        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(inputText);

        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }

        return inputText.split(DEFAULT_DELIMITER);
    }

    private int getParseInt(String inputNumber) {
        int number = Integer.parseInt(inputNumber);
        validationMinusNumber(number);
        return number;
    }

    private void validationMinusNumber(int number) {
        if (number < 0) {
            throw new RuntimeException(MINUS_NUMBER_EXCEPTION_MESSAGE);
        }
    }
}
