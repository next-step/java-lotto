/*
* 문자열의 확인 및 가공을 담당하는 클래스
* */
package Calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

    private static String PATTERN = "//(.)\n(.*)";
    private static String DEFAULT_DELIMETER = ",|:";
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
    * 문자열이 Custom Delimiter를 보유중인 패턴이라면, 해당 구분자로 split하고
    * 아닐 경우엔 기본 Delimiter로 split하여 반환한다.
    * */
    public static String[] splitWithMatcher(String input) {
        Matcher m = Pattern.compile(PATTERN).matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return input.split(DEFAULT_DELIMETER);
    }

    /*
    * 입력받은 피연산자 문자열 집합을 숫자 집합으로 반환한다.
    * */
    public static int[] parseOperand(String[] strOperands) {
        return Arrays.stream(strOperands)
                .mapToInt(Integer::parseInt)
                .filter(o -> checkOperand(o))
                .toArray();
    }

    /*
    * 피연산자가 음수인지 확인한다.
    * */
    public static boolean checkOperand(int operand) {
        if (operand < BOUND_NUMBER) {
            throw new IllegalArgumentException(NEGATVIE_NUMBER_MESSAGE);
        }
        return true;
    }

}
