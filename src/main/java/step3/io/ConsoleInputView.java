package step3.io;

import java.util.Scanner;

public class ConsoleInputView {

    private Scanner scanner;

    public ConsoleInputView() {
        scanner = new Scanner(System.in);
    }

    public String getPrice() {
        return scanner.nextLine();
    }

    public String getVictoryNumbers() {
        return scanner.nextLine();
    }

}
