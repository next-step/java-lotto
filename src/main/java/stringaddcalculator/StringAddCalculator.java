package stringaddcalculator;

public class StringAddCalculator {

    private static String delimitersRegex = ",|:";

    public static int splitAndSum(String inputString) {


        // 빈 입력값의 경우 0 반환
        if (inputString == null || inputString.isEmpty() || inputString.trim().isEmpty()) {
            return 0;
        }

        // 기본 구분자를 이용한 분리 및 합계 반환 구현
        String[] splitedNumsString = inputString.split(delimitersRegex);
        int result = 0;
        for (String numString : splitedNumsString) {
            result += Integer.parseInt(numString);
        }

        return result;
    }
}
