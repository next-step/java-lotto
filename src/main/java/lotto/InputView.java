package lotto;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static String scan(String payload) {
        System.out.println(payload);
        return scanner.next();
    }
}
