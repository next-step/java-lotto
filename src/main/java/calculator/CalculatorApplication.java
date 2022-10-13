package calculator;

import java.util.Scanner;

public class CalculatorApplication {
    private static final Scanner scanner= new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("원하시는 연산을 입력하세요.");
        String text = scanner.nextLine();
        int result = StringCalculator.calculate(text);
        System.out.printf("result : %d \r\n", result);
    }
}
