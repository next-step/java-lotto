package step1;

import java.util.Objects;
import java.util.Scanner;

public class Calculator {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        String input = SCANNER.nextLine();
        validateBlank(input);
    }

    public static void validateBlank(String input) {
        if (Objects.isNull(input) || input.isBlank()) {
            throw new IllegalArgumentException("null이나 빈 문자열을 입력할 수 없습니다.");
        }
    }
}
