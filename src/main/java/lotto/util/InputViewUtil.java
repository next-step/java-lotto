package lotto.util;

import java.util.Scanner;

public class InputViewUtil {

    public static int scannerInt(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);

        return scanner.nextInt();
    }

    public static String scannerString(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);

        return scanner.next();
    }
}
