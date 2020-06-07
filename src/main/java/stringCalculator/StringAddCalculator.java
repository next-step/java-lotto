package stringCalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static int splitAndSum(String calcStr) {
        if (ConditionValidation.isBlank(calcStr)) {
            return 0;
        }

        if (!ConditionValidation.isContainDelimiter(calcStr)) {
            return Operations.strToInt(calcStr);
        }

        String[] numbers = splitStr(calcStr);
        return Operations.operationSum(numbers);
    }

    private static String[] splitStr(String calcStr) {
        if (ConditionValidation.isDefaultDelimiter(calcStr)) {
            return calcStr.split(",|:");
        }

        return splitWithCustomDelimiter(calcStr);
    }

    private static String[] splitWithCustomDelimiter(String calcStr) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(calcStr);

        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }

        return new String[0];
    }
}
