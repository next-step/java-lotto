package calculator.view;

import java.util.Scanner;

public class InputView {
    public static String readInput(Scanner scanner) {
        printInputGuide();
        return scanner.nextLine();
    }

    private static void printInputGuide() {
        System.out.println("계산식을 입력해주세요. 숫자와 사칙연산 사이에는 반드시 공백을 포함해야 합니다.");
        System.out.println("(예: 2 + 3 * 4 / 2)");
    }
}
