package lotto.ui;

import java.util.Scanner;

public class InputView {

    public static final Scanner SCANNER = new Scanner(System.in);

    public static int inputAmount() {
        return SCANNER.nextInt();
    }
}
