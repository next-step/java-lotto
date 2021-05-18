package study.calculator;

import java.util.List;

/**
 * 계산과정을 처리한다.
 */
public class CalculateProcessor {
    /**
     * 목록에 담긴 숫자들을 더한다.
     */
    public static int add(final List<Integer> numbers) {
        return numbers.stream()
                .reduce(0, Integer::sum);
    }
}
