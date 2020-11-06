package lotto.view;

import java.io.PrintWriter;
import java.util.Scanner;

public class InputView {
    private final Scanner scanner;
    private final PrintWriter output;

    public InputView(Scanner scanner, PrintWriter output) {
        this.scanner = scanner;
        this.output = output;
    }


    public int getMoney() {
        output.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }
}
