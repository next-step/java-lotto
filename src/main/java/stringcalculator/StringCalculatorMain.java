package stringcalculator;

import java.util.Scanner;

public class StringCalculatorMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] strings = scanner.nextLine().split(" ");

        Number result = new Number(strings[0]);

        for (int i = 1; i < strings.length; i += 2) {
            Operator operator = new Operator(strings[i]);
            Number number = new Number(strings[i + 1]);
            StringCalculator.calculate(result, operator, number);
        }

        System.out.println(result);
    }
}
