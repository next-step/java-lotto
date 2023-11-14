package calculator.view;

import java.util.Scanner;

public class NumberInputView {

    private static final String BLANK = " ";

    public String[] inputNumbers() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();

        return input.split(BLANK);
    }
}
