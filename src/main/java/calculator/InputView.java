package calculator;

import java.util.Scanner;

public class InputView {

    private InputView() {

    }

    public static final Scanner SCANNER = new Scanner(System.in);

    public static String getInput() {
        System.out.println("사칙 연산을 입력하세요.");
        return SCANNER.nextLine();
    }

}
