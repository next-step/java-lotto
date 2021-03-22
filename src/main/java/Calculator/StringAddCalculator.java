/*
* 문자열 덧셈 계산기를 담당하는 클래스
* */

package Calculator;

import java.util.regex.*;

public class StringAddCalculator {

    private static final int INIT_NUM = 0;
    private static String PATTERN = "//(.)\n(.*)";
    private static String DEFAULT_DELIMETER = ",|:";

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


    public static int splitAndSum(String input) {
        if (StringUtils.checkEmpty(input)) {
            return INIT_NUM;
        }
        int[] operands = StringUtils.parseToIntList(
                splitWithMatcher(input)
        );
        return 0;
    }
}
