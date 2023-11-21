package io;

import java.util.Scanner;

public final class InputView {
    public String input;

    public InputView() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("연산을 입력하세요. 예) 2 + 3 * 4 / 2");
        input = scanner.nextLine();

        if (isBlank())
            throw new IllegalArgumentException();
    }

    private boolean isBlank() {
        return input == null || input.isEmpty();
    }
}
