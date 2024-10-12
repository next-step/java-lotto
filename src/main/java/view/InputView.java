package view;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);
    private final String input;

    public InputView() {
        System.out.println("계산할 수식을 입력하세요.");
        this.input = scanner.nextLine();
        validateInput();
    }

    public String getInput() {
        return input;
    }

    private void validateInput() {
        if (this.input == null || this.input.isBlank()) {
            throw new IllegalArgumentException("null 또는 빈 공백은 입력할 수 없습니다.");
        }
    }
}
