package step1;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private final static int ZERO = 0;
    private final static int NOT_FIND = -1;
    private final static String STRING_PATTERN ="//(.)\n(.*)";

    private StringAddCalculator(){}

    static int splitAndSum(String input) {
        if (input.length() == UserInput.LENGTH_ONE) {
            return Integer.parseInt(input);
        }

        int returnValue = findCustomDelimiter(input);
        if (returnValue >= ZERO) {
            return returnValue;
        }

        return getElementSum(ValidateInput.inputs);
    }


    private static int findCustomDelimiter(String input) {
        Matcher m = Pattern.compile(STRING_PATTERN).matcher(input);

        if (m.find()) {
            String customDelimiter = m.group(1);
            String inputs[] = m.group(2).split(customDelimiter);
            return getElementSum(inputs);
        }
        return NOT_FIND;
    }

    static int getElementSum(String inputs[]) {
        int sum = Arrays.stream(inputs)
                .map(Integer::parseInt)
                .reduce(0, Integer::sum);
        return sum;
    }
}


