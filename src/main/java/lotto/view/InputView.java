package lotto.view;

import java.util.Scanner;

public class InputView implements ConsoleView {
    private Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void print(String str) {
        System.out.println(str);
    }

    public String inputQuestion(String q) {
        this.print(q);
        return this.scanner.nextLine();
    }
}
