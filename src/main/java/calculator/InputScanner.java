package calculator;

import java.util.Scanner;

/**
 * Created by seungwoo.song on 2022-09-28
 */
public class InputScanner {

    private final Scanner scanner;

    public InputScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public String scan() {
        return scanner.nextLine();
    }
}
