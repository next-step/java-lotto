package calculator.view;

import java.util.Scanner;

public class InputView {

    public static final Scanner sc = new Scanner(System.in);

    public static String getText() {
        return sc.nextLine();
    }
}
