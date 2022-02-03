package calculator;

import calculator.domain.StringCalculator;
import java.util.Scanner;

public class CalculatorApplication {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();

        StringCalculator stringCalculator = new StringCalculator();
        System.out.println(stringCalculator.add(text));
    }
}
