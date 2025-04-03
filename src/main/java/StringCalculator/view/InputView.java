package StringCalculator.view;

import StringCalculator.domain.Expression;

import java.util.Scanner;

import static StringCalculator.domain.Expression.isInvalidInputFormat;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static Expression getExpression() {
        while (true) {
            try {
                System.out.println("수식을 입력하세요: (예: 2 + 3 * 4 / 2)");
                String input = SCANNER.nextLine();
                if (isInvalidInputFormat(input)) {
                    System.out.println("제대로 된 형식으로 입력해 주세요. (예: 2 + 3 * 4 / 2)");
                    continue;
                }
                return new Expression(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

