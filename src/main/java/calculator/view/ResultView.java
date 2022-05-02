package calculator.view;

import calculator.domain.StringNumber;

public class ResultView {
    private static final String RESULT_MESSAGE = "계산 결과 : %d";

    private ResultView() {
    }

    public static void printResult(StringNumber stringNumber) {
        System.out.printf((RESULT_MESSAGE) + "%n", stringNumber.toInt());
    }
}
