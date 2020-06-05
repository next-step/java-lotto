package step1.domain;

import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculater {

    private static final Pattern patternCustomDelimiter = Pattern.compile("//(.)\n(.*)");

    private static final String FIXED_DELIMITER = ",|:";


    public int splitAndSum(String inputString) {

        if (checkEmpty(inputString)) {
            return 0;
        }

        // check custom delimiter
        String token = FIXED_DELIMITER;
        String customDelimiter = checkCustomDelimiter(inputString);

        if (!customDelimiter.isEmpty()) {
            token = token + "|" + customDelimiter;
            inputString = removeCustomDelimiter(inputString);
        }

        // split
        String[] numbers = inputString.split(token);

        // find a not a number(s).
        Number.checkNumber(numbers);
        Number.checkNotNumber(numbers);

        // sum
        return Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .sum();

    }


    private boolean checkEmpty(String inputString) {
        // empty check
        return Objects.isNull(inputString) || inputString.isEmpty();
    }

    private String checkCustomDelimiter(String inputString) {
        Matcher matcher = patternCustomDelimiter.matcher(inputString);
        return (matcher.find()) ? matcher.group(1) : new String();
    }

    private String removeCustomDelimiter(String inputString) {
        inputString = inputString.substring(inputString.indexOf('\n') + 1);
        return inputString;
    }


}
