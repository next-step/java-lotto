package step2.view;

import java.util.Scanner;

public class ViewUtils {
    private static final String INPUT_NULL_EMPTY_EXCEPTION_MESSAGE = "내용을 입력해주세요.";

    private static Scanner scanner = new Scanner(System.in);

    private ViewUtils() {
    }

    public static String nextLine() {
        String input = scanner.nextLine();

        if(input == null || input.isEmpty()) {
            throw new IllegalArgumentException(INPUT_NULL_EMPTY_EXCEPTION_MESSAGE);
        }

        return input;
    }

    public static int nextInt() {
        return Integer.parseInt(nextLine());
    }

    public static void printLine(String line) {
        System.out.println(line);
    }
}
