package lotto.view;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public String getInput() {
        return scanner.nextLine();
    }

    public int tryNo(String input) {
        checkBlank(input);
        return Integer.parseInt(input) / 1000;
    }

    public String[] split(String input) {
        checkBlank(input);
        return input.split(", ");
    }

    private void checkBlank(String input){
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("값이 없습니다.");
        }
    }
}
