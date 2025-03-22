package calculator;

import java.util.Scanner;

public class CalculatorApplication {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] elements = getInput().split(" ");

        OperationUnit unit = new OperationUnit();
        for (String element : elements) {
            unit.add(element);

            if (unit.isCalculable()) {
                int result = Calculator.calculate(unit);
                unit.addNumber(result);
            }
        }

        System.out.println(unit.getLeft());
    }

    private static String getInput() {
        String input = scanner.nextLine();

        checkInputValidation(input);

        return input;
    }

    private static void checkInputValidation(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("입력값이 없습니다.");
        }
    }

}
