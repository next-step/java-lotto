package lotto.ui;

import java.util.Scanner;

public class InputScanner {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static String stringScan() {
        return SCANNER.nextLine();
    }

    public static int intScan() {
        return SCANNER.nextInt();
    }

}
