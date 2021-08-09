package stringaddcalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {


    public static int splitAndSum(String inputString) {
        if (inputString == null || inputString.isEmpty()) {
            return 0;
        }

        String delimiterByRegex = ",|:";
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(inputString);
        if (m.find()) {
            String customDelimiter = m.group(1);
            delimiterByRegex += ("|" + customDelimiter);
            return extracted(m.group(2), delimiterByRegex);
        }

        return extracted(inputString, delimiterByRegex);
    }

    private static int extracted(String targetString, String delimiterByRegex) {
        int result = 0;
        String[] numsString= targetString.split(delimiterByRegex);

        for (String numString : numsString) {
            int num = Integer.parseInt(numString);
            if (num < 0) {
                throw new RuntimeException("음수를 입력할 수 없습니다.");
            }
            result += num;
        }
        return result;
    }
}
