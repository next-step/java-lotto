package view;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String WELCOME_MESSAGE = "수식을 입력해주세요.";

    public static String getInput() {
        System.out.println(WELCOME_MESSAGE);
        return scanner.nextLine();
    }
}
