package step1.addCalculator.view;

import java.util.Scanner;

public class InputTextView {

    private static String PLEASE_ENTER_TEXT = "문자를 입력해주세요";

    private static Scanner scanner = new Scanner(System.in);

    public static String inputText() {
        System.out.print(PLEASE_ENTER_TEXT + " : ");
        return scanner.nextLine();
    }
}
