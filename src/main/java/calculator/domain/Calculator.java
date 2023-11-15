package calculator.domain;

import java.util.List;

public class Calculator {

    private static final int INITIAL_RESULT_INDEX = 0;

    public static int calculate(List<Integer> numbers, List<Operator> operators) {
        int result = numbers.get(INITIAL_RESULT_INDEX);

        for (int i = 0; i < operators.size(); i++) {
            Operator operator = operators.get(i);

            result = operator.operate(result, numbers.get(i + 1));
        }

        return result;
    }
}
