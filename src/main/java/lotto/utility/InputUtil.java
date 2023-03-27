package lotto.utility;

import java.util.Scanner;

public class InputUtil {

    public long inputToLong(String message) {
        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLong();
    }

    public int inputToInt(String message) {
        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public String inputToLine(String message) {
        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public String inputToLine() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
