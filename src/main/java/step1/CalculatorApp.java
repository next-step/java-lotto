package step1;

import java.util.Objects;
import java.util.Scanner;

public class CalculatorApp {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        String input = SCANNER.nextLine();
        validateBlank(input);

        int result = Calculator.calculate(input);

        System.out.println(result);
    }

    public static void validateBlank(String input) {
        if (Objects.isNull(input) || input.isBlank()) {
            throw new IllegalArgumentException("null이나 빈 문자열을 입력할 수 없습니다.");
        }
    }
}
