package lotto.view;

import java.util.Scanner;

public class UserConsole {
    private static final String START_MESSAGE = "구입 금액을 입력해 주세요";
    private static final Scanner scanner = new Scanner(System.in);

    private UserConsole() {

    }

    public static int inputString(){
        System.out.println(START_MESSAGE);
        return Integer.valueOf(scanner.nextLine());
    }
}
