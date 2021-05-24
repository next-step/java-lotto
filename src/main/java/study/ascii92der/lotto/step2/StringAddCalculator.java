package study.ascii92der.lotto.step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static int splitAndSum(String stringValues) {
        if (stringValues == null || stringValues.isEmpty()) {
            return 0;
        }

        return sum(split(stringValues));
    }

    public static String[] split(String stringValues) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(stringValues);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return stringValues.split("[,:]");
    }

    public static int sum(String[] values) {
        int result = 0;
        for (String value : values) result += parsingValue(value);
        return result;
    }

    private static int parsingValue(String value) {
        int parsedNumber;
        try {
            parsedNumber = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Not a number", e);
        }
        if (parsedNumber < 0) {
            throw new RuntimeException("invalid range number , Negative number");
        }
        return parsedNumber;
    }
}
