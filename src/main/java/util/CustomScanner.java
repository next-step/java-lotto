package util;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CustomScanner {
    private static final String INPUT_INT_ANNOUNCEMENT = "정수를 입력해주세요.";
    private static final String INPUT_COMMA_SEPARATED_INT_ANNOUNCEMENT = "콤마로 구분된 정수를 입력해주세요.";

    public static int scanInt(Scanner scanner) {
        try {
            int input = scanner.nextInt();
            scanner.nextLine();
            return input;
        } catch (InputMismatchException e) {
            System.out.println(INPUT_INT_ANNOUNCEMENT);
            scanner.nextLine();
            return scanInt(scanner);
        }
    }

    public static List<Integer> scanCommaSeparatedInts(Scanner scanner) {
        try {
            String input = scanner.nextLine();
            return parseNumbers(input);
        } catch (NumberFormatException e) {
            System.out.println(INPUT_COMMA_SEPARATED_INT_ANNOUNCEMENT);
            return scanCommaSeparatedInts(scanner);
        }
    }

    private static List<Integer> parseNumbers(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }
}
