package calculator.ui;

import java.util.Scanner;

public class StringCalculatorView {

    private static final StringCalculatorView INSTANCE = new StringCalculatorView();

    private static final Scanner SCANNER = new Scanner(System.in);

    private StringCalculatorView() {

    }

    public static StringCalculatorView getInstance() {
        return INSTANCE;
    }

    public String input() {
        return SCANNER.nextLine();
    }

    public void output(int result) {
        System.out.println(result);
    }
}
