package StringCalculator;

import StringCalculator.model.StringCalculator;

import java.util.Scanner;

public class Main {
    public static void main(String []args){
        StringCalculator calculator = new StringCalculator();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        System.out.println(calculator.calculate(input));
    }
}
