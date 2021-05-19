package step2;

import java.util.Scanner;

public class StringAddCalculatorApp {
    public static void main(String[] args) {
        System.out.println("계산할 문자열을 입력해주세요.");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(new StringAddCalculator().calculate(input));
    }
}
