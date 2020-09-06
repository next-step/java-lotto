package lotto.view;

import java.util.Scanner;

public class InputView {
    private final static Scanner sScanner = new Scanner(System.in);
    private final static Scanner iScanner = new Scanner(System.in);

    private InputView() {
        throw new AssertionError();
    }

    public static String inputText() {
        return sScanner.nextLine();
    }

    public static Integer inputInt() {
        return iScanner.nextInt();
    }
}
