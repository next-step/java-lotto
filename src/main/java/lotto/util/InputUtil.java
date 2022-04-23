package lotto.util;

import lotto.model.lotto.LottoNumber;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class InputUtil {

    private static final String DEFAULT_DELIMITER = ",";

    private static final Scanner scanner = new Scanner(System.in);

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

    public static Set<LottoNumber> readNumbers() {
        return readNumbers(DEFAULT_DELIMITER);
    }

    private static Set<LottoNumber> readNumbers(String delimiter) {
        String readNumbers = readLine().replace(" ", "");
        return convertNumbers(readNumbers, delimiter);
    }

    private static Set<LottoNumber> convertNumbers(String readNumbers, String delimiter) {
        return Arrays.stream(readNumbers.split(delimiter))
                .map(number -> LottoNumber.create(Integer.parseInt(number)))
                .collect(Collectors.toSet());
    }

}
