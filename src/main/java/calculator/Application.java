package calculator;

import java.util.Scanner;

public class Application {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        CalculatorController calculatorController = new CalculatorController(new Calculator(), new CharacterParser());
        String expression = scanner.nextLine();
        System.out.print(calculatorController.calculatingValue(expression));
    }
}
