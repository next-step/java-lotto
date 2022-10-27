package StringCalculator.View;

import java.util.Scanner;

public class InputView {
    static String INPUT_PATTERN = "^[ 0-9+/*-]+$";

    public static String input() {
        Scanner scanner = new Scanner(System.in);
        return validate(scanner.next());
    }

    public static String validate(String inputString) {
        if (inputString == null) {
            throw new IllegalArgumentException("null은 입력 불가");
        } else if (inputString.isBlank()) {
            throw new IllegalArgumentException("공백은 입력 불가");
        } else if (!inputString.matches(INPUT_PATTERN)) {
            throw new IllegalArgumentException("숫자와 연산자 (+, -, /, *) 외 입력 불가");
        }
        return inputString;
    }
}
