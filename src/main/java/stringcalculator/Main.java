package stringcalculator;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("계산식을 입력하세요: ");
        System.out.println("결과: " + StringCalculator.calculate(scanner.nextLine()));
    }
}
