package calculator.view;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String DELIMITER = " ";

    public static List<String> inputOperators() {
        System.out.println("계산식을 입력하세요. (계산식은 공백으로 구분)");
        String operators = SCANNER.nextLine();
        validateInput(operators);
        return split(operators);
    }

    private static void validateInput(String input) {
        if(input == null || input.isEmpty()) {
            throw new IllegalArgumentException("허용되지 않은 입력값입니다.");
        }
    }

    private static List<String> split(String input) {
        return List.of(input.split(DELIMITER));
    }
}
