package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String input() {
        System.out.println("계산 식을 입력해 주세요.");
        return scanner.nextLine();
    }
}
