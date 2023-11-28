package calculator;

import java.util.Scanner;

public class StringCalculatorMain{
    public static void main(String[] args) {
        StringCalculator cal = new StringCalculator();
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println("결과 : " + cal.calculate(input));
    }
}
