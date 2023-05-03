package step1;

import java.util.Scanner;

public class StringCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Calculator calculator = new Calculator(input);
        System.out.println("calculate result is : " + calculator.calculate());
    }
}
