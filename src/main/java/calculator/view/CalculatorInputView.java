package calculator.view;

import java.util.Scanner;

public class CalculatorInputView {
    public static String getInputValue() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
