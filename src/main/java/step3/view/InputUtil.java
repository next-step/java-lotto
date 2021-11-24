package step3.view;

import java.util.Scanner;

public class InputUtil {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String NOT_NUMBER_ERROR_MESSAGE = "숫자가 아닙니다.";

    public static String readLine() {
        return SCANNER.nextLine();
    }

    public static int readInt() {
        try {
            return Integer.parseInt(readLine());
        } catch (NumberFormatException e) {
            System.out.println(NOT_NUMBER_ERROR_MESSAGE);
            return readInt();
        }
    }

    private InputUtil() {
    }
}
