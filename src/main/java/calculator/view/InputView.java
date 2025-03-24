package calculator.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public String getInput() {
        System.out.println("수식을 입력하세요.");
        String input = scanner.nextLine();

        checkNotBlank(input);

        return input;
    }

    public void checkNotBlank(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("입력값이 없습니다.");
        }
    }
}
