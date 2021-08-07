package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    static final String NUMBER_REG_EXP = "^[0-9]+$";
    static final String DELIMITER_REG_EXP = "//(.)\\n(.*)";

    public static int splitAndSum(String inputString) {
        if (inputString == null || inputString.isEmpty()) {
            return 0;
        }
        String[] splitArray = splitInputString(inputString);
        return sumNumbers(convertStringArrayToIntArray(splitArray));
    }

    public static String[] splitInputString(String inputString) {
        Matcher matcher = Pattern.compile(DELIMITER_REG_EXP).matcher(inputString);
        if (matcher.find()) {
            String delimiter = matcher.group(1);
            return matcher.group(2).split(delimiter);
        }
        return inputString.split(",|:");
    }

    public static int[] convertStringArrayToIntArray(String[] splitArray) {
        return Arrays.stream(splitArray).mapToInt(StringCalculator::stringToInt).toArray();
    }

    public static int sumNumbers(int[] splitNumbers) {
        return Arrays.stream(splitNumbers).sum();
    }

    public static int stringToInt(String strNumber) {
        if (!Pattern.compile(NUMBER_REG_EXP).matcher(strNumber).find()) {
            throw new IllegalArgumentException("0 이상의 숫자만 입력하세요.");
        }
        return Integer.parseInt(strNumber);
    }
}
