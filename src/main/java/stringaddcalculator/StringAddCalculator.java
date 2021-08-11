package stringaddcalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static String delimitersRegex = ",|:";

    public static int splitAndSum(String inputString) {
        int result = 0;

        // 빈 입력값의 경우 0 반환
        if (inputString == null || inputString.isEmpty() || inputString.trim().isEmpty()) {
            return 0;
        }

        // custom 연산자 입력 시 이를 이용한 분할
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(inputString);
        if(matcher.find()){
            delimitersRegex += ("|" + matcher.group(1));
            String[] splitedNumsString = matcher.group(2).split(delimitersRegex);
            for (String numString : splitedNumsString) {
                result += Integer.parseInt(numString);
            }
            return result;

        }

        // 기본 구분자를 이용한 분리 및 합계 반환 구현
        String[] splitedNumsString = inputString.split(delimitersRegex);
        for (String numString : splitedNumsString) {
            result += Integer.parseInt(numString);
        }

        return result;
    }
}
