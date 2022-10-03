package step1;

import java.util.Objects;
import java.util.Scanner;

public class CalculatorApp {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        String input = SCANNER.nextLine();
        validateBlank(input);

        Calculator calculator = new Calculator();

    }

    public static void validateBlank(String input) {
        if (Objects.isNull(input) || input.isBlank()) {
            throw new IllegalArgumentException("null이나 빈 문자열을 입력할 수 없습니다.");
        }
    }

    public static int toInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("피연산자 변환 과정에서 오류가 발생했습니다. 정수를 입력해주세요.");
        }
    }
}
