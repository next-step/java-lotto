package stringCalculator.view;

import stringCalculator.view.InputScanner;

public class Printer {

    public static String requestInput() {
        System.out.println("사칙연산 수식을 입력하세요.");
        return InputScanner.stringScan();
    }

    public static void printResult(int result) {
        System.out.printf("계산 결과 : %d%n", result);
    }

}
