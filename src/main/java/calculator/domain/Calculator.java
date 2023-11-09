package calculator.domain;

import java.util.List;

public class Calculator {

    private static final Integer START_RESULT_INDEX = 0;

    public int calculate(List<String> operators, List<Integer> numbers) {
        int result = numbers.get(START_RESULT_INDEX);
        for (int i = 1; i < numbers.size(); i++) {
            Operation operation = Operation.fromString(operators.get(i - 1))
                    .orElseThrow(() -> new IllegalArgumentException("사칙연산 기호만 사용 가능합니다."));

            result = operation.apply(result, numbers.get(i));
        }
        return result;
    }

}
