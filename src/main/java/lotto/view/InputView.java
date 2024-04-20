package lotto.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static String readInput(String message) {
        System.out.println();
        System.out.println(message);

        return SCANNER.nextLine();
    }
}
