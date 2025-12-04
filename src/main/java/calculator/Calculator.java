package calculator;

import static view.OutputView.getCalculationResult;

public class Calculator {

    public static void calculate(String[] input) {
        int result = Integer.parseInt(input[0]);

        for (int i = 1; i < input.length; i += 2) {
            Operator from = Operator.from(input[i]);
            result = from.apply(result, Integer.parseInt(input[i + 1]));
        }
        getCalculationResult(result);
    }
}
