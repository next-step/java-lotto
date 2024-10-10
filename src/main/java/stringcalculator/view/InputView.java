package stringcalculator.view;

import java.util.Scanner;

public class InputView {

    public static final Scanner SCANNER = new Scanner(System.in);

    public static String input() {
        System.out.println("문자열을 입력해주세요.");
        return SCANNER.nextLine();
    }
}
