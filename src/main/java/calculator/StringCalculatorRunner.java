package calculator;

import java.util.Scanner;

public class StringCalculatorRunner {
    public static void main(String[] args) {
        StringCalculator stringCalculator = new StringCalculator();

        Scanner scanner = new Scanner(System.in);
        System.out.println("사칙연산을 위한 문자열을 입력해주세요.");
        String input = scanner.nextLine();
        int result = stringCalculator.calc(new InputString(input));
        System.out.printf("계산결과는 %d 입니다.\n", result);
    }
}
