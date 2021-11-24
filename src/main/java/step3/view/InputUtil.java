package step3.view;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputUtil {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String NOT_NUMBER_ERROR_MESSAGE = "숫자가 아닙니다. 다시 입력해주세요";
    private static final String NUMBER_SPLIT_REGEX = ",";

    public static int readInt() {
        try {
            return Integer.parseInt(readLine());
        } catch (NumberFormatException e) {
            System.out.println(NOT_NUMBER_ERROR_MESSAGE);
            return readInt();
        }
    }

    private static String readLine() {
        return SCANNER.nextLine();
    }

    public static List<Integer> readNumbers() {
        try {
            return readIntegers();
        } catch (NumberFormatException e) {
            System.out.println(NOT_NUMBER_ERROR_MESSAGE);
            return readNumbers();
        }
    }

    private static List<Integer> readIntegers() {
        return Arrays.stream(readStringNumbers())
            .map(String::trim)
            .map(Integer::valueOf)
            .collect(toList());
    }

    private static String[] readStringNumbers() {
        return readLine().split(NUMBER_SPLIT_REGEX);
    }

    private InputUtil() {
    }
}
