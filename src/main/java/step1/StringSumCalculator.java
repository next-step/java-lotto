package step1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSumCalculator {

    public int sum(final String inputText) {

        if (inputText == null || inputText.trim().isEmpty()) {
            return 0;
        }

        return splitAndSum(inputText);
    }

    private int splitAndSum(final String inputText) {
        int result = 0;
        String[] inputNumbers = splitInputText(inputText);

        for (String inputNumber : inputNumbers) {
            result += Integer.parseInt(inputNumber);
        }
        return result;
    }

    private String[] splitInputText(String inputText) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(inputText);

        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }

        return inputText.split(",|:");
    }

}
