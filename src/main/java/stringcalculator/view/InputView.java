package stringcalculator.view;

import java.util.Scanner;

public class InputView {

    private static final String EMPTY_VALUE = "0";

    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static String getExpression() {
        System.out.println(",혹은 :로 구분된 덧셈 식을 입력하세요 (ex. \"1,2\", \"1;2\")");
        String input = scanner.nextLine().replace("\\n", "\n");
        return checkNullOrEmpty(input);
    }

    private static String checkNullOrEmpty(String input) {
        if (input == null || input.isEmpty()) {
            return EMPTY_VALUE;
        }
        return input;
    }
}
