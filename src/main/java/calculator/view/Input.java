package calculator.view;

import java.util.Scanner;

public class Input {

    private static final String CALCULATOR_TEXT = "숫자와 사칙연산을 입력해주세요(공백으로 구분됩니다)";
    private static final Scanner scanner = new Scanner(System.in);

    public static String getInput() {
        System.out.println(CALCULATOR_TEXT);
        return scanner.nextLine();
    }

}
