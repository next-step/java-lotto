package stringCalculator.views;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static String askInputExpression() {
        System.out.print("수식 입력: ");
        return scanner.nextLine();
    }
}
