package calculator.view;

import calculator.domain.Number;

public class ResultView {
    public static void printResult(Number number) {
        System.out.println("결과: " + number.getValue());
    }
}
