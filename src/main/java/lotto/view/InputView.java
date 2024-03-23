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
        int i;
        try {
            i = Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("숫자만 입력해주세요.");
        }
        if (i < 1000) {
            throw new IllegalArgumentException("금액이 모자랍니다.");
        }
        return i / 1000;
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
