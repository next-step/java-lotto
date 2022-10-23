package lotto.view.input;

import java.util.Scanner;

public class ConsoleUserInterface implements UserInterface {
    private final Scanner scanner;

    public ConsoleUserInterface() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public String getString() {
        return scanner.nextLine();
    }

    @Override
    public int getInt() {
        int number = scanner.nextInt();
        scanner.nextLine();
        return number;
    }

    @Override
    public void show(String message) {
        System.out.println(message);
    }
}
