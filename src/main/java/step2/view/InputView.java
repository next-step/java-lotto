package step2.view;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String input() {
        System.out.println("계산할 문자열을 입력하세요. (예. 2 + 3)");
        return scanner.nextLine();
    }
}
