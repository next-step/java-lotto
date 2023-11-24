package stringcalculator.view;

import java.util.Scanner;

public class InputView {
    private static final String USER_INPUT_MSG = "사칙연산을 수행할 문자를 입력해주세요.";
    private static final Scanner scanner = new Scanner(System.in);

    public static String userInput() {
        System.out.println(USER_INPUT_MSG);
        return scanner.nextLine();
    }

}
