package step1.utils;

import step1.domain.Expression;

import java.util.Scanner;

public class CalculatorScanner {

    public static Expression getInput() {
        Scanner scanner = new Scanner(System.in);
        return new Expression(scanner.nextLine());
    }
}
