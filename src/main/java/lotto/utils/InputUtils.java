package lotto.utils;

import java.util.Scanner;

public class InputUtils {
    private static final Scanner SCANNER = new Scanner(System.in);

    private InputUtils() {
        throw new IllegalStateException("InputUtils 직접 생성 금지");
    }

    public static Integer inputInt(String message) {
        return Integer.parseInt(SCANNER.nextLine());
    }

    public static String inputString(String message) {
        return SCANNER.nextLine();
    }
}
