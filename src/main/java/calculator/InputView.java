package calculator;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner= new Scanner(System.in);

    public static String readExpression() {
        System.out.print("계산식을 입력하세요: ");
        return scanner.nextLine();
    }
}
