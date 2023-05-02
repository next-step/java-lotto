package calculator.view;

import calculator.domain.Number;

public class OutputView {
    public static void printResult(Number result) {
        System.out.printf("계산 결과 : %d\n", result.value());
    }
}
