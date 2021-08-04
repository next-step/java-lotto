package stringcalculation;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String CUSTOM_PATTERN = "//(.)\n(.*)";
    private static final String NUMBER_PATTERN = "[0-9]";

    public static int splitAndSum(String inputText) {
        if (!validText(inputText)) {
            return 0;
        }
        String[] operandArr = getOperandArr(inputText);
        if (operandArr.length == 1) {
            return 1;
        }

        return sum(operandArr);
    }

    public static String[] getOperandArr(String text) {
        Matcher m = Pattern.compile(CUSTOM_PATTERN).matcher(text);
        String customDelimiter;
        String regExp = "[,:^]+";
        if (m.find()) {
            customDelimiter = m.group(1);
            text = m.group(2);
            regExp = "[,:"+customDelimiter+"^]+";
        }
        return text.split(regExp);
    }

    public static void validNumber(String number) {
        if (!number.matches(NUMBER_PATTERN)) {
            throw new RuntimeException();
        }
    }

    public static void validNegative(int number) {
        if (number < 0) {
            throw new RuntimeException();
        }
    }

    public static boolean validText(String inputText) {
        if (Objects.isNull(inputText) || inputText.trim().length() == 0) {
            return false;
        }
        return true;
    }

    public static int sum(String[] operandArr) {
        int result = 0;
        for (String numberStr : operandArr) {
            validNumber(numberStr);
            int number = Integer.parseInt(numberStr);
            validNegative(number);
            result += number;
        }
        return result;
    }
}
