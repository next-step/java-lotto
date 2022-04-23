package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputUtil {

    private static final String DEFAULT_DELIMITER = ",";

    private final static Scanner scanner = new Scanner(System.in);

    private InputUtil() {
    }

    public static String readLine() {
        return scanner.nextLine();
    }

    public static long readLongNumber() {
        return Long.parseLong(readLine());
    }

    public static int readIntNumber() {
        return Integer.parseInt(readLine());
    }

    public static List<Integer> readNumbers() {
        return readNumbers(DEFAULT_DELIMITER);
    }

    public static List<Integer> readNumbers(String delimiter) {
        String readNumbers = readLine().replace(" ", "");
        return convertNumbers(readNumbers, delimiter);
    }

    private static List<Integer> convertNumbers(String readNumbers, String delimiter) {
        return Arrays.stream(readNumbers.split(delimiter))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

}
