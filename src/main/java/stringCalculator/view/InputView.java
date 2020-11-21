package stringCalculator.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner sc = new Scanner(System.in);

    private InputView() {
    }

    public static String inputExpression() {
        System.out.println("[문자열 덧셈 계산기] ex) “1,2:3” => 6 / //;\\n1;2;3");
        return sc.nextLine();
    }
}
