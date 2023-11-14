package calculator.view;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static String expression() {
        System.out.println("식을 입력해주세요.");
        return scanner.nextLine();
    }
}
