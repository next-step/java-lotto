package step1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StringCalculator stringCalculator = new StringCalculator();
        System.out.println("문자열을 입력하세요");
        Scanner scanner = new Scanner(System.in);

        int result = stringCalculator.calculate(scanner.nextLine());

        System.out.println(result);
    }
}
