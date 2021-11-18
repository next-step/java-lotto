package pluscalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static int splitAndSum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens = m.group(2).split(customDelimiter);
            return calculate(tokens);
        }
        String[] tokens = input.split("[,:]");

        return calculate(tokens);
    }

    private static int calculate(String[] tokens) {
        int result = 0;
        for (String s : tokens) {
            int number = Integer.parseInt(s);
            if (number < 0) {
                throw new RuntimeException();
            }
            result += number;
        }
        return result;
    }


}
