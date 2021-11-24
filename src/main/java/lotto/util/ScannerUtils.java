package lotto.util;

import java.util.Scanner;
import lotto.exception.NotNumberException;

public class ScannerUtils {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static int nextInt() {
        try {
            return Integer.parseInt(SCANNER.nextLine());
        } catch (NumberFormatException e) {
            throw new NotNumberException();
        }
    }

    public static String nextLine() {
        return SCANNER.nextLine();
    }

}
