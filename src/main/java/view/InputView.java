package view;

import java.util.Objects;
import java.util.Scanner;

public class InputView {

    private final static Scanner scanner = new Scanner(System.in);
    private final static String SEPARATOR = " ";

    public static String[] inputEquation() {
        System.out.println("계산하고 싶은 식을 입력해주세요.");
        String input = scanner.nextLine();
        validateInput(input);

        return input.split(SEPARATOR);
    }

    private static void validateInput(final String input) {
        if (Objects.isNull(input) || input.isEmpty()) {
            throw new RuntimeException("입력 값이 누락되었습니다.");
        }
    }
}
