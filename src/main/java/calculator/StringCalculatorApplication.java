package calculator;

import java.util.List;
import java.util.Scanner;

public class StringCalculatorApplication {

    public static void main(String[] args) {
        List<String> operations = StringCalculator.getOperations(input());

        int result = StringCalculator.calculate(operations);

        print(result);
    }

    private static String input() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("사칙 연산 문자열을 입력해주세요.");
        return scanner.nextLine();
    }

    private static void print(int output) {
        System.out.println(output);
    }

}
