package calculator.view;

import java.util.Scanner;

public class CalculateInputView {
    private static final Scanner scanner = new Scanner(System.in);

    private CalculateInputView() {
        throw new AssertionError();
    }

    public static String scan(String inputText) {
        System.out.println(inputText);
        return scanner.nextLine();
    }
}
