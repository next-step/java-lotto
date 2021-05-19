package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Numbers {
    private static final int emptyNumber = 0;
    private static final String defaultCommaDelimiter = ",";
    private static final String defaultColonDelimiter = ":";
    private static final Pattern customDelimiterPattern = Pattern.compile("//(.)\n(.*)");
    private static final String isNumberRegex = "[0-9]+";
    private static final int customDelimiterGroup = 1;
    private static final int customNumbersGroup = 2;
    private static final String invalidNumberFormatErrorMessage = "Invalid input number.";

    public int[] getNumberArray(String input) {
        if(input == null || input.isEmpty()) {
            return new int[] {emptyNumber};
        }

        return convertStringArrayToIntArray(split(input));
    }

    private String[] split(String input) {
        Matcher matcher = customDelimiterPattern.matcher(input);
        if(matcher.find()) {
            String customDelimiter = matcher.group(customDelimiterGroup);
            String customNumberInput = matcher.group(customNumbersGroup);
            return customNumberInput.split(customDelimiter);
        }

        return input.split(defaultCommaDelimiter + "|" + defaultColonDelimiter);
    }

    private int[] convertStringArrayToIntArray(String[] strings) {
        int[] numberArray = new int[strings.length];
        for(int i=0; i< strings.length; i++) {
            throwInvalidNumberFormatException(strings[i]);
            numberArray[i] = Integer.valueOf(strings[i]);
        }

        return numberArray;
    }

    private void throwInvalidNumberFormatException(String input) {
        if(!input.matches(isNumberRegex)) {
            throw new RuntimeException(invalidNumberFormatErrorMessage);
        }
    }
}
