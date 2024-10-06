package calculator;

import java.util.Scanner;

public class CalculatorMain {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        System.out.println("계산할 수식을 입력해주세요.");
        final String userInput = scanner.nextLine();
        final int calculate = Calculator.calculate(userInput);
        System.out.println("결과: " + calculate);
    }
}
