package study;

import java.util.List;

public class StringAddCalculator {

    private StringAddCalculator() {
    }

    public static int calculate(String expression) {
        if(ValidateUtil.validateEmptyExpression(expression)) {
            return 0;
        }

        List<Integer> numbers = SplitUtil.splitExpression(expression);
        int result = 0;

        for (Integer number : numbers) {
            if(number < 0) {
                throw new RuntimeException();
            }

            result += number;
        }

        return result;
    }
}
