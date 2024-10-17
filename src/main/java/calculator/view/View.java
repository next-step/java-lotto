package calculator.view;

import calculator.domain.Input;

import java.util.Scanner;

public class View {
    public Input input() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();
        return new Input(input);
    }

    public void output(int value) {
        System.out.println(value);
    }
}
