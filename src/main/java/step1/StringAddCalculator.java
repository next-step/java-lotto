package step1;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private final static int ZERO = 0;
    private final static int NOT_FIND = -1;

    static int splitAndSum(String input) {
        if (input.length() == UserInput.LENGTH_ONE) {
            return Integer.parseInt(input);
        }

        int returnValue = hasCustomDelimiter(input);
        if (returnValue >= ZERO) return returnValue;

        String[] inputs = input.split(UserInput.DELIMITER);
        return elementSum(inputs);
    }


    private static int hasCustomDelimiter(String input) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);

        if (m.find()) {
            String customDelimiter = m.group(1);
            String inputs[] = m.group(2).split(customDelimiter);
            return elementSum(inputs);
        }
        return NOT_FIND;
    }

    private static int elementSum(String inputs[]) {
        int sum = Arrays.stream(inputs)
                .map(Integer::parseInt)
                .reduce(0, Integer::sum);
        return sum;
    }
}


