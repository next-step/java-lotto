package calculator;

import java.util.Scanner;

public class StringCalculatorApplication {
    private static Scanner scan = new Scanner(System.in);

    public static void main (String[] args) {
        System.out.println("Enter the String with valid Mathematical Expression");
        String input = scan.nextLine();
        int result = StringCalculator.calculate(input);
        System.out.print("Result : " + result);
    }
}
