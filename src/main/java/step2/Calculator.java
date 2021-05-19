package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    public int addNumberBetweenSeparator(String input) {
        int result = 0;
        if (!checkNull(input)) {
            String[] numbers = separateWithSeparator(input);
            result = addNumbers(numbers);
        }
        return result;
    }

    private int addNumbers(String[] numbers) {
        int result = 0;
        for (String numbesr : numbers) {
            result += parseNumber(numbesr);
        }

        return result;
    }

    private int parseNumber(String numbesr) {
        return !checkNull(numbesr) ? Integer.parseInt(numbesr) : 0;
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
