package calculator.view;

import java.util.Scanner;

public class NumberInputView {

    public String inputNumbers() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
