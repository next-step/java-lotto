package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String DEFAULT_DELIMITER = ",|;";
    private static final String DELIMITER_PATTERN = "//(.)\n(.*)";

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
            total += Integer.parseInt(number);
        }
        return total;
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
