package calculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String calculateString;
        System.out.println("계산할 문자열을 입력하세요.");
        calculateString = scanner.nextLine();

        StringCalculator calculator = new StringCalculator(calculateString);
        System.out.println(calculator.calculate());
    }
}
