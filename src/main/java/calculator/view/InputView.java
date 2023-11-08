package calculator.view;

import calculator.domain.OperationValidator;
import java.util.Scanner;

public class InputView {

    private InputView() {
    }

    public static String input(Scanner scanner) {
        System.out.println("계산 할 문자를 입력해 주세요");
        System.out.println("(예 : 2 + 3 * 4 / 2)");
        String input = scanner.nextLine();
        OperationValidator.valid(input);
        return input;
    }
}
