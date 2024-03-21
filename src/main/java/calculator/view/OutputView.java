package calculator.view;

import calculator.domain.Calculator;

public class OutputView {
    public static void showResult(Calculator calculator) {
        System.out.println(calculator.getCurrentResult());
    }
}
