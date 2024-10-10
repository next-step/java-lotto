package calculator;

import java.util.Scanner;

public class StringCalculatorApp {
    final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("계산식 입력 : ");
        String expression = scanner.nextLine();

        System.out.println("계산식 결과 : " + StringCalculator.calculate(expression));
    }
}
