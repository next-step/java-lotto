package lotto.view;

import java.util.Scanner;

public class InputView {

    public static final Scanner SCANNER = new Scanner(System.in);

    public static String receiveMoney() {
        return SCANNER.nextLine();
    }
}
