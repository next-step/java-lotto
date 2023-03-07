package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    /**
     * 메인 덧셈 계산기
     *
     * @param inputString : 입력값
     * @return : 합계
     */
    public static int plus(String inputString) {
        if (blankAndNullCheck(inputString)) {
            return 0;
        }
        if (onlyOneStringCheck(inputString)) {
            return Integer.parseInt(inputString);
        }
        if (onlyCommaSeperatorCheck(inputString)) {
            return stringArraySum(inputString.split(","));
        }
        Seperator seperator = new Seperator(inputString);
        return new Operands(Operand.parseOperand(seperator.getSperatedValue())).operandsSum();
    }

    /**
     * 연산자 문자열 배열 합계
     *
     * @param stringArray : 연산자 문자열 배열
     * @return : 연산자 문자열 합계
     */
    private static int stringArraySum(String[] stringArray) {
        return Arrays.stream(stringArray).map(Integer::parseInt).mapToInt(Integer::intValue).sum();
    }

    /**
     * 공백 및 빈 문자 체크
     *
     * @param inputString : 연산자 문자열 배열
     * @return : boolean
     */
    private static boolean blankAndNullCheck(String inputString) {
        return inputString == null || inputString.isBlank();
    }

    /**
     * 한자리 숫자 오는 경우 그대로 리턴하기 위해 체크
     *
     * @param inputString : 연산자 문자열 배열
     * @return : boolean
     */
    private static boolean onlyOneStringCheck(String inputString) {
        Matcher m = Pattern.compile("(^\\d{1,10}$)").matcher(inputString);
        return m.find();
    }

    /**
     * 콤마 구분자만 오는 경우, 바로 합계를 리턴하기 위해 체크
     *
     * @param inputString : 연산자 문자열 배열
     * @return : boolean
     */
    private static boolean onlyCommaSeperatorCheck(String inputString) {
        Matcher m = Pattern.compile("^[0-9,]+$").matcher(inputString);
        return m.find();
    }
}
