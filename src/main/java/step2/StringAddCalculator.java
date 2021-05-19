package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final Pattern VALID_DATA_PATTERN = Pattern.compile("^[0-9]+$");


    public int calculate(String data) {
        if (data == null || data.isEmpty()) {
            return 0;
        }
        String[] numbers = splitToNumbers(data);
        return addNumbers(numbers);
    }

    private String[] splitToNumbers(String data) {
        String delimiter = DelimiterExtractor.extractDelimiter(data);
        return splitDataWithDelimiter(delimiter);
    }

    private String[] splitDataWithDelimiter(String delimiter) {
        String splitData = DelimiterExtractor.getSplitData();
        return splitData.split(delimiter);
    }

    private int addNumbers(String[] numbers) {
        int total = 0;
        for ( String number : numbers) {
            total += parseInt(number);
        }
        return total;
    }

    private int parseInt(String number) {
        Matcher matcher = VALID_DATA_PATTERN.matcher(number);
        if (matcher.find()) {
            return Integer.parseInt(number);
        }
        throw new RuntimeException("invalid data");
    }



}
