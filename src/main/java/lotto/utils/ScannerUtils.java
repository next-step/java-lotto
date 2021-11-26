package lotto.utils;

import java.util.Scanner;

import lotto.exception.InvalidScannerInputException;

public final class ScannerUtils {

    private static final Scanner scanner = new Scanner(System.in);

    private ScannerUtils() {
    }

    public static int nextInt() {
        validateNextIntOrThrow();
        int input = scanner.nextInt();
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
        return input;
    }

    private static void validateNextIntOrThrow() {
        if (!scanner.hasNextInt()) {
            throw new InvalidScannerInputException("input is not a numeric string.");
        }
    }

    public static String nextLine() {
        return scanner.nextLine();
    }
}
