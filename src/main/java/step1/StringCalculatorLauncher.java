package step1;

import java.util.Scanner;

public class StringCalculatorLauncher {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println(StringCalculator.calculate(scanner.nextLine()));
    }
}
