/*
* 문자열 덧셈 계산기를 담당하는 클래스
* */

package calculator.domain;

import calculator.util.Mapper;
import calculator.util.StringUtils;

import java.util.function.BinaryOperator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final int INIT_NUM = 0;
    private static String PATTERN = "//(.)\n(.*)";
    private static Delimiter delimiter;

    /*
     * 문자열이 Custom Delimiter를 보유중인 패턴이라면, 해당 구분자로 split하고
     * 아닐 경우엔 기본 Delimiter로 split하여 반환한다.
     * */
    public static String[] splitWithMatcher(String input) {
        Matcher m = Pattern.compile(PATTERN).matcher(input);
        if (m.find()) {
            delimiter = new Delimiter(m.group(1));
            return delimiter.splitWithDelimiter(m.group(2));
        }
        delimiter = new Delimiter();
        return delimiter.splitWithDelimiter(input);
    }


    /*
    * 계산기의 핵심 로직
    * 문자열을 입력받아 계산값을 반환한다.
    * */
    public static int calculate(String input) {
        if (StringUtils.checkEmpty(input)) {
            return INIT_NUM;
        }
        String[] operandsStr = splitWithMatcher(input);
        Operands operands = new Operands(StringUtils.parseToIntList(operandsStr));
        BinaryOperator<Integer> operator = Operator.add();

        return Mapper.operandToInt(operands.operateAll(operator));
    }
}
