package calculator.view;

import java.util.Scanner;

public class InputView {
    public static final String STR1 = "사칙연산을 입력해주세요.";

    public static final Scanner scanner = new Scanner(System.in);

    public String calInput() {
        System.out.print(STR1);
        return scanner.nextLine();
    }
}
