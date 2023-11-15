package step1;

import java.util.Scanner;

public class InputView {
    public static String inputMathExpression() {
        System.out.println("식을 입력하세요 : ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
