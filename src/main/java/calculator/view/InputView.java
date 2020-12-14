package calculator.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static String inputMathExpression() {
        System.out.print("커스텀구분자 혹은 수식을 입력하세요 : ");
        String input = scanner.nextLine();
        return InputView.addQuestion(input);
    }

    private static String addQuestion(String input) {
        if(InputView.isDelimiter(input)) {
            System.out.print("\n수식을 입력하세요 : ");
            return input + "\n" +scanner.nextLine();
        }
        return input;
    }

    private static boolean isDelimiter(String input) {
        return input.startsWith("//");
    }
}
