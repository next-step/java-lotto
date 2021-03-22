/*
* 문자열 덧셈 계산기를 담당하는 클래스
* */

package Calculator;

public class StringAddCalculator {

    private static final int INIT_NUM = 0;


    public static int splitAndSum(String input) {
        if (StringUtils.checkEmpty(input)) {
            return INIT_NUM;
        }
        int[] operands = StringUtils.parseOperand(
                StringUtils.splitWithMatcher(input)
        );
        return Operator.add(operands);
    }
}
