package stringcalculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringCalculator stringCalculator = new StringCalculator(scanner.nextLine());
        stringCalculator.calculate();
        System.out.println(stringCalculator.getResult());
    }
}
