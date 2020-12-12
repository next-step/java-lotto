package stringcalculator;

import stringcalculator.domain.StringAddCalculator;

import java.util.Scanner;

public class StringAddApp {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("수식을 입력하세요. (예 1,2:3) >> ");

        String input = scanner.nextLine();
        int result = StringAddCalculator.splitAndSum(input);

        System.out.printf("결과는 %d 입니다.%n", result);
    }
}
