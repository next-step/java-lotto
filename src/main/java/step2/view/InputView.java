package step2.view;

import java.util.Scanner;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);

    public static int readInt(String message) {
        System.out.println(message);
        return toInt(scanner.nextLine());
    }

    private static int toInt(String nextLine) {
        try {
            return Integer.parseInt(nextLine);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(nextLine + " : 유효한 정수 값이 아닙니다.");
        }
    }

    public static String readString(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }
}
