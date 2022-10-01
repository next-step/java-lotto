package step1;

import java.util.Scanner;

public class CalculatorApplication {
    private static final String INPUT_MESSAGE = "계산식을 입력해주세요.";
    private static final String OUTPUT_MESSAGE = "계산 결과";

    public static void main(String[] args) {
        System.out.println(INPUT_MESSAGE);
        Scanner scanner = new Scanner(System.in);
        StringCalculator stringCalculator = new StringCalculator(scanner.nextLine());
        System.out.printf("%s: %d%n", OUTPUT_MESSAGE, stringCalculator.calculate().getValue());
    }
}
