package utils;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public String inputExpression() {
        return scanner.nextLine();
    }

    public static int toInt(String number) {
        return Integer.parseInt(number);
    }
}
