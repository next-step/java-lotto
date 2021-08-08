package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final String NUMBER_REG_EXP = "^[0-9]+$";
    private static final String DELIMITER_REG_EXP = "//(.)\\n(.*)";
    private static final String DEFAULT_DELIMITER = ",|:";
    private static final int DELIMITER_GROUP = 1;
    private static final int NUMBER_GROUP = 2;

    public static int splitAndSum(String inputString) {
        if (inputString == null || inputString.isEmpty()) {
            return 0;
        }
        String[] splitArray = splitInputString(inputString);
        return sumNumbers(convertStringArrayToIntArray(splitArray));
    }

    private static String[] splitInputString(String inputString) {
        Matcher matcher = Pattern.compile(DELIMITER_REG_EXP).matcher(inputString);
        if (matcher.find()) {
            String delimiter = matcher.group(DELIMITER_GROUP);
            return matcher.group(NUMBER_GROUP).split(delimiter);
        }
        return inputString.split(DEFAULT_DELIMITER);
    }

    private static int[] convertStringArrayToIntArray(String[] splitArray) {
        return Arrays.stream(splitArray)
                     .mapToInt(StringCalculator::stringToInt)
                     .toArray();
    }

    private static int sumNumbers(int[] splitNumbers) {
        return Arrays.stream(splitNumbers)
                     .sum();
    }

    private static int stringToInt(String strNumber) {
        validateNumber(strNumber);
        return Integer.parseInt(strNumber);
    }

    private static void validateNumber(String strNumber) {
        if (!Pattern.compile(NUMBER_REG_EXP).matcher(strNumber).find()) {
            throw new InvalidInputException("0 이상의 숫자만 입력하세요.");
        }
    }
}
