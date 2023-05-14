package calculator.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {}

    public static String input() {
        System.out.println("계산할 문자열을 입력하세요.");
        String input = scanner.nextLine();
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
        return input;
    }
}
