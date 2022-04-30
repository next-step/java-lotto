package calculator;


import calculator.app.Calculator;

import java.util.Scanner;

public class Application {
    private static final Scanner SCANNER = new Scanner(System.in);

    private static String inputLine() {
        System.out.print("수식 : ");
        return SCANNER.nextLine();
    }

    private static void printResult(int result) {
        System.out.printf("결과 : %d%n", result);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        printResult(calculator.calculate(inputLine()));
    }
}
