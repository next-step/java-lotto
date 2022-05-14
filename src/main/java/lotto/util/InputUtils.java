package lotto.util;

import java.util.Scanner;

public class InputUtils {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String NEW_LINE_CHARACTER = "[\\r\\n]+";

    private InputUtils() {
        throw new AssertionError();
    }

    public static String scan(String inputText) {
        System.out.println(inputText);
        scanner.skip(NEW_LINE_CHARACTER);
        return scanner.nextLine();
    }

    public static int scanNumber(String inputText) {
        System.out.println(inputText);
        return scanner.nextInt();
    }
}