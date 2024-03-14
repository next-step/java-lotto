package step1;

import step1.calculator.StringCalculator;

import java.util.Scanner;

public class StringCalculatorApplication {
    public static void main(String[] args) {
        System.out.println("사칙 연산식을 입력해주세요(공백 기준 분리)");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        StringCalculator stringCalculator = new StringCalculator();
        System.out.println(stringCalculator.calculate(input));
    }
}
