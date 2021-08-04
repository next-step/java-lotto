package stringcalculation;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
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
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        String customDelimiter;
        String regExp = "[,:^]+";
        if (m.find()) {
            customDelimiter = m.group(1);
            text = m.group(2);
            regExp = "[,:"+customDelimiter+"^]+";
        }
        return text.split(regExp);
    }

    public static int validNumber(String number) {
        int parseNumber = 0;
        try {
            parseNumber = Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new RuntimeException();
        }
        if (parseNumber < 0) {
            throw new RuntimeException();
        }
        return parseNumber;
    }

    public static Boolean validText(String inputText) {
        if (Objects.isNull(inputText) || inputText.trim().length() == 0) {
            return false;
        }
        return true;
    }

    public static int sum(String[] operandArr) {
        int result = 0;
        for (String number : operandArr) {
            result += validNumber(number);
        }
        return result;
    }
}
