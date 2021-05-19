package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String DEFAULT_DELIMITER = ",|;";
    private static final String DELIMITER_PATTERN = "//(.)\n(.*)";
    private static final String VALID_DATA_PATTERN = "^[0-9]+$";

    public int calculate(String data) {
        if (data == null || data.isEmpty()) {
            return 0;
        }
        String[] numbers = splitToNumbers(data);
        return addNumbers(numbers);
    }

    private int addNumbers(String[] numbers) {
        int total = 0;
        for ( String number : numbers) {
            total += parseInt(number);
        }
        return total;
    }

    private int parseInt(String number) {
        Matcher matcher = Pattern.compile(VALID_DATA_PATTERN).matcher(number);
        if (matcher.find()) {
            return Integer.parseInt(number);
        }
        throw new RuntimeException("invalid data");
    }

    private String[] splitToNumbers(String data) {
        Pattern pattern = Pattern.compile(DELIMITER_PATTERN);
        Matcher matcher = pattern.matcher(data);
        String delimiter = DEFAULT_DELIMITER;
        if (matcher.find()) {
            delimiter = matcher.group(1);
            data = matcher.group(2);
        }
        return data.split(delimiter);
    }

}
