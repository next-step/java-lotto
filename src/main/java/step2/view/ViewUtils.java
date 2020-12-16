package step2.view;

import java.util.Scanner;

public class ViewUtils {
    private static final String INPUT_NULL_EMPTY_EXCEPTION_MESSAGE = "내용을 입력해주세요.";

    private Scanner scanner;

    public ViewUtils() {
        this.scanner = new Scanner(System.in);
    }

    public String nextLine() {
        String input = scanner.nextLine();

        if(input == null || input.isEmpty()) {
            throw new IllegalArgumentException(INPUT_NULL_EMPTY_EXCEPTION_MESSAGE);
        }

        return input;
    }

    public int nextInt() {
        return Integer.parseInt(nextLine());
    }

    public void printLine(String line) {
        System.out.println(line);
    }
}
