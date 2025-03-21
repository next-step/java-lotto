package calculator;

import java.util.Scanner;

public class View {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static String inputExpression() {
        System.out.println("수식을 입력하세요.");
        return SCANNER.nextLine();
    }

    public static void printResult(int result) {
        System.out.println("결과는 " + result + " 입니다.");
    }
}
