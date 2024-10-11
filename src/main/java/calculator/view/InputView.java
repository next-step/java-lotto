package calculator.view;

import calculator.domain.Input;

import java.util.Scanner;

public class InputView {
    public static Input input() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();
        return new Input(input);
    }
}
