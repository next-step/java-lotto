package calculator.view;

import java.util.Scanner;

public class CalculatorView {
    public static String getInputValue() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
