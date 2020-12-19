package calculator;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static String requestInput() {
        System.out.println("계산할 문자열을 입력해 주세요.");
        return scanner.nextLine();
    }
}
