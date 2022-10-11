package stringcalculate.view;

import stringcalculate.InputValue;

import java.util.Scanner;

public class InputView {

    public static InputValue askInput(Scanner scanner) {
        String input = scanner.nextLine();
        return new InputValue(input);
    }

}
