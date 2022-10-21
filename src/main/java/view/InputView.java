package view;

import domain.Calculator;

import java.util.Scanner;

public class InputView {
    public static Calculator inputExpressions() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("계산식을 입력해주세요.");
            return new Calculator(scanner.nextLine());
        }
    }
}
