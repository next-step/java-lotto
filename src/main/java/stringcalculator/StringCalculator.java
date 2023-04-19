package stringcalculator;

import java.util.Scanner;

public class StringCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Expression expression = new Expression(input);
        System.out.println("계산 결과: " + expression.evaluate());
    }
}
