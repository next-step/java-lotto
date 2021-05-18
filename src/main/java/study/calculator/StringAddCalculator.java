package study.calculator;

import java.util.List;

/**
 * 문자 덧셈을 처리하는 계산기.
 */
public class StringAddCalculator {

    /**
     * 문자를 분리하여 더한다.
     *
     * @param text 입력된 문자로된 숫자
     * @return 숫자들의 합
     */
    public static int splitAndSum(final String text) {
        List<Integer> numbers = TextParser.parseFromText(text);
        return CalculateProcessor.add(numbers);
    }
}
