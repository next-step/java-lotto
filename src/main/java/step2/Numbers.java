package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Numbers {
    private static final int EMPTY_NUMBER = 0;
    private static final String DEFAULT_COMMA_DELIMITER = ",";
    private static final String DEFAULT_COLON_DELIMITER = ":";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final int CUSTOM_DELIMITER_GROUP = 1;
    private static final int CUSTOM_NUMBER_ARRAY_GROUP = 2;
    private static final String NUMBER_FORMAT_CHECK_REGEX = "[0-9]+";
    private static final String invalidNumberFormatErrorMessage = "Invalid input number.";

    public int[] getNumberArray(String input) {
        if(input == null || input.isEmpty()) {
            return new int[] {EMPTY_NUMBER};
        }

        return convertStringArrayToIntArray(split(input));
    }

    private String[] split(String input) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
        if(matcher.find()) {
            String customDelimiter = matcher.group(CUSTOM_DELIMITER_GROUP);
            String customNumberInput = matcher.group(CUSTOM_NUMBER_ARRAY_GROUP);
            return customNumberInput.split(customDelimiter);
        }

        return input.split(DEFAULT_COMMA_DELIMITER + "|" + DEFAULT_COLON_DELIMITER);
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
        if(!input.matches(NUMBER_FORMAT_CHECK_REGEX)) {
            throw new RuntimeException(invalidNumberFormatErrorMessage);
        }
    }
}
