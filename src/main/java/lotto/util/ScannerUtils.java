package lotto.util;

import java.util.Scanner;

public class ScannerUtils {

    private static final Scanner SCANNER = new Scanner(System.in);

    private ScannerUtils() {
    }

    public static int nextInt() {
        return SCANNER.nextInt();
    }

    public static String nextLine() {
        return SCANNER.nextLine();
    }

}
