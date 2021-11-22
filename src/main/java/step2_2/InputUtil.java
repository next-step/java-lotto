package step2_2;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputUtil {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String NOT_INTEGER_ERROR_MESSAGE = "숫자를 입력하세요";

    private InputUtil() {
    }

    public static int readInt() {
        try {
            return Integer.parseInt(readLine());
        } catch (NumberFormatException e) {
            System.out.println(NOT_INTEGER_ERROR_MESSAGE);
            return readInt();
        }
    }

    private static String readLine() {
        return SCANNER.nextLine();
    }

    public static List<Integer> readNumbers() {
        try {
            return readNumberList();
        } catch (NumberFormatException e) {
            System.out.println(NOT_INTEGER_ERROR_MESSAGE);
            return readNumbers();
        }
    }

    private static List<Integer> readNumberList() {
        String[] stringNumbers = readLine().split(",");

        return Arrays.stream(stringNumbers)
            .map(String::trim)
            .map(Integer::valueOf)
            .collect(toList());
    }
}
