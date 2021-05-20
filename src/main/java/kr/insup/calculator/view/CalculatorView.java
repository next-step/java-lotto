package kr.insup.calculator.view;

import java.util.Scanner;

public class CalculatorView {

    private static final Scanner scanner = new Scanner(System.in);

    public static String getInput() {
        System.out.println("구분자와 계산할 값을 입력하세요");
        return scanner.nextLine();
    }

    public static void showResult(int result) {
        System.out.println("계산 결과는 '" + result + "' 입니다");
    }
}
