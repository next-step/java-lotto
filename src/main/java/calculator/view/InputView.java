package calculator.view;

import java.util.Scanner;

public class InputView {

    static Scanner scanner = new Scanner(System.in);

    public static String inputMathExprssion() {
        System.out.println("계산할 수식을 입력해주세요.");
        return scanner.nextLine();
    }
}
