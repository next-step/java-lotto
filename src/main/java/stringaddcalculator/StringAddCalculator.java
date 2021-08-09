package stringaddcalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static int splitAndSum(String inputString) {
        if (inputString == null || inputString.isEmpty()) {
            return 0;
        }
        String delimiterByRegex = ",|:";
        int result = 0;
        // java.util.regex 패키지의 Matcher, Pattern import
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(inputString);
        if (m.find()) {
            String customDelimiter = m.group(1);
            delimiterByRegex += ("|" + customDelimiter);
            String[] numsString= m.group(2).split(delimiterByRegex);
            System.out.println(delimiterByRegex);
            // 덧셈 구현
            for (String numString : numsString) {
                int num = Integer.parseInt(numString);
                if (num < 0) {
                    throw new RuntimeException("음수를 입력할 수 없습니다.");
                }
                result += num;
            }
            return result;
        }
        String[] numsString= inputString.split(delimiterByRegex);
        // 덧셈 구현
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
