package views;

import domain.symbol.Operand;

public class ResultView {
    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printResult(Operand result) {
        System.out.println("계산 결과는 " + result.value() + "입니다.");
    }
}
