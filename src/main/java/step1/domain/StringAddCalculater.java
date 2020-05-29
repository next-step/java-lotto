package step1.domain;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculater {

    private final static Pattern patternCustomDelimiter = Pattern.compile("//(.)\n(.*)");
    private final static Pattern patternNumbersOnly = Pattern.compile("^[-+]?[0-9]+$");

    private static final String FIXED_DELIMITER = ",|:";
    private static String customDelimiter = "";


    public int splitAndSum(String inputString) {

        if (checkEmpty(inputString)) {
            return 0;
        }

        String token = FIXED_DELIMITER;

        if (checkCustomDelimiter(inputString)) {
            inputString = inputString.substring(inputString.indexOf('\n') + 1);
            token = token + "|" + customDelimiter;
        }


        // split
        String[] numbers = inputString.split(token);

        // find a not a number(s).
        for (String number : numbers) {
            checkNumber(number);
        }

        // find a negative number(s).
        if (Arrays.stream(numbers).map(Integer::parseInt).filter(number -> number < 0).count() > 0) {
            throw new RuntimeException("Found a negative number(s)");
        }

        // sum
        return Arrays.stream(numbers).mapToInt(Integer::parseInt).sum();

    }


    private boolean checkEmpty(String inputString) {
        // empty check
        if (null == inputString || inputString.isEmpty()) {
            return true;
        }
        return false;
    }

    private boolean checkCustomDelimiter(String inputString) {
        Matcher matcher = patternCustomDelimiter.matcher(inputString);
        if (matcher.find()) {
            customDelimiter = matcher.group(1);
            return true;
        }
        return false;
    }

    private void checkNumber(String inputString) {
        if (!patternNumbersOnly.matcher(inputString).matches()) {
            throw new RuntimeException("Found a Not a number(s)");
        }
    }


}
