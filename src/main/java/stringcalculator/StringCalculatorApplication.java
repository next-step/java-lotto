package stringcalculator;

import stringcalculator.domain.StringCalculator;

import java.util.Scanner;

public class StringCalculatorApplication {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        System.out.print("계산할 문자열을 입력하세요 : ");
        System.out.println("결과 : " + StringCalculator.calculate(scanner.nextLine()));
    }
}
