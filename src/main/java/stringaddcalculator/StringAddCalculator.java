package stringaddcalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final int ZERO = 0;

    public int splitAndSum(String inputString) {
        if (isNullOrEmpty(inputString)) {
            return ZERO;
        }
        return sum(inputString);
    }

    private int sum(String inputString) {
        int result = 0;
        for (String splitNumber : this.splitString(inputString)) {
            result += checkNegative(Integer.parseInt(splitNumber));
        }
        return result;
    }

    private int checkNegative(int checkNumber) {
        if(checkNumber < 0) {
            throw new RuntimeException();
        }
        return checkNumber;
    }

    private String[] splitString(String inputString) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(inputString);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return inputString.split(",|:");
    }

    private boolean isNullOrEmpty(String inputString) {
        if (inputString == null || inputString.equals("")) {
            return true;
        }
        return false;
    }
}
