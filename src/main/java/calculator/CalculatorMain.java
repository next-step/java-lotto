package calculator;

import java.util.Scanner;

public class CalculatorMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringCalculator stringCalculator = new StringCalculator();

        int result = stringCalculator.calculation(scanner.nextLine());
        System.out.println(result);
    }
}
