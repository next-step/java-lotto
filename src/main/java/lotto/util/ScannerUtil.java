package lotto.util;

import java.util.Scanner;

public class ScannerUtil {

    private final static Scanner scanner = new Scanner(System.in);

    private ScannerUtil() {
    }

    public static String readLine() {
        return scanner.nextLine();
    }

}
