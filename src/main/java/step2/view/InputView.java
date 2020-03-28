package step2.view;

import java.util.Scanner;

public class InputView {
    private static final String INPUT_NULL_EMPTY_EXCEPTION = "내용을 입력해주세요.";
    private static final String NUMBER_FORMAT_EXCEPTION = "입력된 내용이 숫자가 아닙니다.";
    private Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public String readLine() {
        String input = scanner.nextLine();

        if(input == null || input.isEmpty()) {
            throw new IllegalArgumentException(INPUT_NULL_EMPTY_EXCEPTION);
        }

        return input;
    }

    public int inputToInt() {
        try {
            return Integer.parseInt(readLine());
        } catch(NumberFormatException e) {
            throw new NumberFormatException(NUMBER_FORMAT_EXCEPTION);
        }
    }
}
