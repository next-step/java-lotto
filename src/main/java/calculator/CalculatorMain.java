package calculator;

import calculator.domain.StringCalculator;

import java.util.Scanner;

public class CalculatorMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("계산할 식을 입력하세요.");
        String input = scanner.nextLine();

        int result = new StringCalculator().splitAndCalculate(input);
        System.out.println("결과 : " + result);
    }
}
