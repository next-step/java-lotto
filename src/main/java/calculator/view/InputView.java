package calculator.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String askExpression() {
        System.out.print("계산할 연산식을 입력하세요: ");
        return scanner.nextLine();
    }

}
