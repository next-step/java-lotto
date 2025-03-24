package step1.view;

import step1.domain.Operand;

public class ResultView {
    public static void printResult(Operand operand) {
        System.out.println("계산 결과: " + operand.getValue());
    }
}
