package step2_2;

import java.util.Scanner;

public class InputUtil {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String NOT_INTEGER_ERROR_MESSAGE = "숫자를 입력하세요";

    private InputUtil() {
    }

    public static int readInt() {
        try {
            return Integer.parseInt(readLine());
        } catch (NumberFormatException e) {
            System.out.println(NOT_INTEGER_ERROR_MESSAGE);
            return readInt();
        }
    }

    public static String readLine() {
        return SCANNER.nextLine();
    }
}
