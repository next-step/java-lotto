package calculator.view;

import java.util.Scanner;

public class InputView {

    public static String input() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
