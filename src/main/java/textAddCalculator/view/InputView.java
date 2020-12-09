package textAddCalculator.view;

import java.util.Scanner;

public class InputView {
    private static Scanner sc = new Scanner(System.in);

    public static String inputText() {
        System.out.println("문자열 입력하세요.");
        return sc.nextLine();
    }
}
