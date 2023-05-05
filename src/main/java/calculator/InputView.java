package calculator;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String inputExpression() {
        System.out.println("계산식을 입력해 주세요.(숫자와 사칙 연산자 사이에는 공백입력)");
        return scanner.nextLine();
    }
}
