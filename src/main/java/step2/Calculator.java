package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    private static final String IS_NOT_VALIDE_NUMBER = "음수가 아닌 숫자만 가능합니다.";

    public int addNumberBetweenSeparator(String input) {
        String[] numbers = separateWithSeparator(input);
        return addNumbers(numbers);
    }

    private int addNumbers(String[] numbers) {
        int result = 0;
        for (String numbesr : numbers) {
            result += parseNumber(numbesr);
        }

        return result;
    }

    private int parseNumber(String numbesr) {
        int result = 0;
        if (!checkNull(numbesr)) {
            checkValidation(numbesr);
            result = Integer.parseInt(numbesr);
        }
        return result;
    }

    private void checkValidation(String numbesr) {
        if (!Pattern.matches("^[0-9]+$", numbesr)) {
            throw new IllegalArgumentException(IS_NOT_VALIDE_NUMBER);
        }
    }

    private String[] separateWithSeparator(String input) {
        String[] result = separateWithCustomSeparator(input);
        result = separateWithCommaOrColon(result, input);

        return result;
    }

    private String[] separateWithCommaOrColon(String[] result, String input) {
        if (result.length == 0) {
            result = input.split(",|:");
        }

        return result;
    }

    private String[] separateWithCustomSeparator(String input) {
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(input);
        String[] result = {};

        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            result = matcher.group(2).split(customDelimiter);
        }

        return result;
    }

    private boolean checkNull(String input) {
        return null == input || "".equals(input.trim());
    }

}
