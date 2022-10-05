package stringcalculator;

import java.util.Scanner;

public class CalculatorApplication {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        int result = Calculator.calculate(SCANNER.nextLine());
        System.out.println(result);
    }

}
