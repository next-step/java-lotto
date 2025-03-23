package utils;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public String inputExpression() {
        return scanner.nextLine();
    }
}
