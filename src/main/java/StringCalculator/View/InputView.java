package StringCalculator.View;

import java.util.Scanner;

public class InputView {
    public static String input() {
        Scanner scanner = new Scanner(System.in);
        return validate(scanner.next());
    }

    public static String validate(String inputString) {
        return inputString;
    }
}
