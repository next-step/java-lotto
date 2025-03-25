package step1.util;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static String inputExpression() {
        System.out.println("계산할 식을 입력해 주세요.");
        return scanner.nextLine();
    }
}
