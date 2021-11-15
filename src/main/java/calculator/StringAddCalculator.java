package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static int splitAndSum(String input){
        if(isEmptyOrNull(input)) return 0;
        String[] numbers = getNumberArray(input);
        return Arrays.stream(numbers).mapToInt(Integer::parseInt).sum();
    }

    private static String[] getNumberArray(String input) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return input.split(",|:");
    }

    private static boolean isEmptyOrNull(String input){
        return input == null || input.trim().isEmpty();
    }
}