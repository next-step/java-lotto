package stringadder.view;

import java.util.Scanner;

public class UserConsole {

    private static final String START_MESSAGE = "문자열 입력해주세요.";
    private static final Scanner scanner = new Scanner(System.in);

    private UserConsole() {

    }

    public static String inputString() {
        System.out.println(START_MESSAGE);
        return scanner.nextLine();
    }
}
