package utils;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public String inputExpression() {
        return scanner.nextLine();
    }

    public static int toInt(String number) {
        return Integer.parseInt(number);
    }

    public static List<String> parse(String input) {
        return List.of(input.split(" "));
    }
}
