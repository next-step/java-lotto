package view;

import domain.Expression;
import java.util.Scanner;

public class InputView {
    public static Expression inputExpressions() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("계산식을 입력해주세요.");
            return new Expression(scanner.nextLine());
        }
    }
}
