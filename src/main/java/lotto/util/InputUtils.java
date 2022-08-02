package lotto.util;

import java.util.Scanner;

public class InputUtils {
    private static final Scanner scanner = new Scanner(System.in);

    private InputUtils() {
        throw new AssertionError();
    }

    public static String scan(String inputText) {
        System.out.println(inputText);
        return scanner.nextLine();
    }

    public static String scan() {
        return scanner.nextLine();
    }
}