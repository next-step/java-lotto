package calculator.view;

import java.util.Scanner;

public class InputView {

    private static Scanner sc = new Scanner(System.in);

    public static String getFormula() {
        System.out.println("계산식을 입력하세요.(숫자와 사칙 연산 사이에는 반드시 빈 공백이 있어야함)");
        return sc.nextLine();
    }
}
