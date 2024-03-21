package view;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public String getInput() {
        return scanner.nextLine();
    }

    public String[] split(String s) {
        checkBlank(s);
        return s.split(" ");
    }
    private void checkBlank(String s){
        if (s == null || s.isBlank()) {
            throw new IllegalArgumentException("값이 없습니다.");
        }
    }
}
