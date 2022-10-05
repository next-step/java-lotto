package calculator.view;

import java.util.Scanner;

public class Input {

    private static final String ASK_CALCULATOR = "숫자와 사칙연산을 입력해주세요(공백으로 구분됩니다) 예시) 2 + 3 * 4 / 2";

    private static final Scanner scanner = new Scanner(System.in);

    public static String getInput() {
        System.out.println(ASK_CALCULATOR);
        return scanner.nextLine();
    }
}
