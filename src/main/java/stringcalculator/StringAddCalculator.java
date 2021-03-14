package stringcalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public int splitAndSum(String input) {
        int result = 0;

        if (isInValidation(input)) {
            return 0;
        }

        if ((input.charAt(0) >= 49 && input.charAt(0) <= 57) && input.length() == 1) {
            return Integer.parseInt(input);
        }

        String[] data;
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            data = m.group(2).split(customDelimiter);
        } else {
            data = input.split(",|:");
        }

        for (int i = 0; i < data.length; i++) {
            isNegative(Integer.parseInt(data[i]));
            result = sum(result, Integer.parseInt(data[i]));
        }

        return result;
    }

    public boolean isInValidation(String input) {
        return input == null || input.isEmpty();
    }

    private void isNegative(int data) {
        if (data < 0) {
            throw new RuntimeException();
        }
    }

    public int sum(int left, int right) {
        return left + right;
    }
}
