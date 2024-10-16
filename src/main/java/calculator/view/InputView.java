package calculator.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static String input() {
        System.out.println("계산식 입력 : ");

        String input = SCANNER.nextLine();

        if (input.isBlank()) {
            throw new IllegalArgumentException("빈값이 입력 되었습니다.");
        }

        return input;
    }
}