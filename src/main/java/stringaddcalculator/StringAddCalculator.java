package stringaddcalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static String delimitersRegex = ",|:";

    public static int splitAndSum(String inputString) {
        // 빈 입력값의 경우 0 반환
        if (isNullOrEmpty(inputString)) {
            return 0;
        }

        // custom 연산자 입력 시 이를 이용한 분할
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(inputString);
        if(matcher.find()){
            delimitersRegex += ("|" + matcher.group(1));
            String[] splitedNumsString = matcher.group(2).split(delimitersRegex);
            return getResult(splitedNumsString);

        }

        // 기본 구분자를 이용한 분리 및 합계 반환 구현
        String[] splitedNumsString = inputString.split(delimitersRegex);
        return getResult(splitedNumsString);
    }

    private static boolean isNullOrEmpty(String inputString){
        return inputString == null || inputString.isEmpty() || inputString.trim().isEmpty();
    }

    private static int getResult(String[] splitedNumsString) {
        int result = 0;
        for (String numString : splitedNumsString) {
            int num = Integer.parseInt(numString);
            if (num < 0) {
                throw new RuntimeException("숫자는 0 이상이어야 합니다.");
            }
            result += num;
        }
        return result;
    }
}
