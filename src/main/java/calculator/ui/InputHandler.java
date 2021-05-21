package calculator.ui;

import java.util.Scanner;

public enum InputHandler {
    INSTANCE;

    public String readLine() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

}
