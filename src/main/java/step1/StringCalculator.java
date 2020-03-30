package step1;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private int result;
    private static final String SEPERATOR_CHARACTER = ",|:";
    private static final String CUSTOM_SEPERATOR_CHARACTER = "//(.)\n(.*)";
    private static final int ZERO = 0;

    public StringCalculator() {
        this.result = ZERO;
    }

    public int splitAndSum(String inputString) {
        if (isNullOrEmpty(inputString)) {
            return ZERO;
        }
        return sum(inputSplit(inputString));
    }

    private int stringToInteger(String input) {
        if (input == null || "".equals(input)) {
            return ZERO;
        }
        return Integer.parseInt(input);
    }

    private int sum(String[] inputSplit) {
        for (String input : inputSplit) {
            result += checkNegativeNumber(stringToInteger(input));
        }
        return result;
    }

    private boolean isNullOrEmpty(String input) {
        if (input == null || "".equals(input)) {
            return true;
        }
        return false;
    }

    private String[] inputSplit(String inputString) {
        Matcher m = Pattern.compile(CUSTOM_SEPERATOR_CHARACTER).matcher(inputString);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return inputString.split(SEPERATOR_CHARACTER);
    }

    private Integer checkNegativeNumber(Integer inputNumber) {
        if (inputNumber < 0) {
            throw new RuntimeException();
        }
        return inputNumber;
    }


}
