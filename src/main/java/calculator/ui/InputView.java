package calculator.ui;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String CALCULATOR_SEPARATOR = " ";

    public static List<String> input() {
        System.out.println("계산식을 입력해주세요.");

        String inputString = SCANNER.nextLine();
        validateInputString(inputString);
        return List.of(inputString.split(CALCULATOR_SEPARATOR));
    }

    private static void validateInputString(String inputString) {
        if (inputString.isBlank()) {
            throw new IllegalArgumentException("빈값을 넣을 수 없습니다.");
        }
    }
}
