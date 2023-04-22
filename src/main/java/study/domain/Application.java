package study.domain;

import study.domain.util.FormulaParser;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        final String input = getString();

        final int calculate = getCalculate(input);

        System.out.println("계산 결과 = " + calculate);
    }

    private static int getCalculate(final String input) {
        final Calculator calculator = new Calculator(new FormulaParser(input));
        final int calculate = calculator.calculate();

        return calculate;
    }

    private static String getString() {
        Scanner scanner = new Scanner(System.in);
        final String input = scanner.nextLine();
        return input;
    }
}
