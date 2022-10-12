package stringcalculate.view;

import stringcalculate.InputValue;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    public static InputValue askInput() {
        String input = scanner.nextLine();
        return new InputValue(input);
    }

}
