/*
* 문자열의 확인 및 가공을 담당하는 클래스
* */
package calculator.util;

import java.util.Arrays;

public class StringUtils {


    private static int BOUND_NUMBER = 0;
    private static String NEGATVIE_NUMBER_MESSAGE = "음수는 계산할 수 없습니다.";


    /*
    * 문자열이 비어있는지 여부를 확인한다.
    * */
    public static boolean checkEmpty(String input) {
        if (input == null || input.isEmpty() || input.equals("")) {
            return true;
        }
        return false;
    }

    /*
    * 입력받은 피연산자 문자열 집합을 int형 집합으로 반환한다.
    * */
    public static int[] parseToIntList(String[] strOperands) {
        return Arrays.stream(strOperands)
                .mapToInt(Integer::parseInt)
                .toArray();
    }


}
