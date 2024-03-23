package view.io.console;

import java.util.Scanner;

import view.io.Input;

public class ConsoleInput implements Input {

    private static final Scanner scanner = new Scanner(System.in);

    @Override
    public String readLine() {
        return scanner.nextLine();
    }
}
