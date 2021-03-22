/*
* 문자열 덧셈 계산기를 담당하는 클래스
* */

package Calculator;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringAddCalculator {

    private static final int INIT_NUM = 0;
    private static String PATTERN = "//(.)\n(.*)";

    /*
     * 문자열이 Custom Delimiter를 보유중인 패턴이라면, 해당 구분자로 split하고
     * 아닐 경우엔 기본 Delimiter로 split하여 반환한다.
     * */
    public static String[] splitWithMatcher(String input) {
        Matcher m = Pattern.compile(PATTERN).matcher(input);
        if (m.find()) {
            return StringUtils.splitWithDelimiter(m.group(2), new Delimiter(m.group(1)));
        }
        return StringUtils.splitWithDelimiter(input, new Delimiter());
    }

    /*
    * 숫자 집합을 받아 피연산자 집합을 담고있는 Operands 객체를 반환한다.
    * */
    public static Operands intArrToOperands(int[] arr) {
        List<Operand> operandList = Arrays.stream(arr)
                .mapToObj(Operand::new)
                .filter(Operand::checkOperand)
                .collect(Collectors.toList());
       return new Operands(operandList);
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
        Operands operands = intArrToOperands(StringUtils.parseToIntList(operandsStr));
        BinaryOperator<Integer> operator = Operator.add();

        return Mapper.operandToInt(operands.operateAll(operator));
    }
}
