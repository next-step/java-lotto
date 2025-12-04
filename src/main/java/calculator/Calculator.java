package calculator;

import static view.OutputView.getCalculationResult;

public class Calculator {

    public static void calculate(String[] input) {
        validate(input);
        int result = Integer.parseInt(input[0]);

        for (int i = 1; i < input.length; i += 2) {
            Operator from = Operator.from(input[i]);
            result = from.apply(result, Integer.parseInt(input[i + 1]));
        }
        getCalculationResult(result);
    }

    private static void validate(String[] input) {
        if (input == null || input.length == 0) {
            throw new IllegalArgumentException("입력 값이 null이거나 빈 공백 문자일 수 없습니다.");
        }
    }
}
