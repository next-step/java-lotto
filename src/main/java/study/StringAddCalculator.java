package study;

import java.util.List;

public class StringAddCalculator {

    private StringAddCalculator() {
    }

    public static int calculate(String expression) {
        List<Integer> numbers = SplitUtil.splitExpression(expression);
        int result = 0;

        for (Integer number : numbers) {
            result += number;
        }

        return result;
    }
}
