package calculator.view;

import java.util.Scanner;

public class InputView {

    public static String scanInput() {
        System.out.println("계산할 식을 입력하세요.");
        String input = scanString();
        if (input.isBlank()) {
            throw new IllegalArgumentException("식이 입력되지 않았습니다.");
        }
        return input;
    }

    private static String scanString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
