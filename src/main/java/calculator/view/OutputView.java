package calculator.view;

import calculator.dto.CalculationResult;

public class OutputView {
    public static void output(CalculationResult calculationResult) {
        System.out.println(calculationResult.value);
    }
}
