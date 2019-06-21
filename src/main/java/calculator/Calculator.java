package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    private static final String REGEX_OF_DEFAULT_SEPARATOR = "[,:]";
    private static final String REGEX_OF_CUSTOM_SEPARATOR = "//(.)\n(.*)";

    public static int calculate(String input) {
        String[] elementsOninput = splitBySeparator(input);
        return sum(elementsOninput);
    }

    private static String[] splitBySeparator(String input) {
        String[] elementsOninput = input.split(REGEX_OF_DEFAULT_SEPARATOR);

        Matcher matcher = Pattern.compile(REGEX_OF_CUSTOM_SEPARATOR).matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            elementsOninput = matcher.group(2).split(customDelimiter);
        }
        return elementsOninput;
    }

    private static int sum(String[] elementsOninput) {
        int result = 0;
        for (String element : elementsOninput) {
            result += Integer.parseInt(element);
        }
        return result;
    }
}
