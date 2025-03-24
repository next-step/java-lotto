package step1.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static String getExpressionString() {
        System.out.println("계산할 수식을 입력해주세요.");
        return SCANNER.nextLine().trim();
    }
}
