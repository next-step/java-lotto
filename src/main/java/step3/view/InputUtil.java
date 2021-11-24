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

    public static List<Integer> readIntList() {
        try {
            return getIntList();
        } catch (NumberFormatException e) {
            System.out.println(NOT_NUMBER_ERROR_MESSAGE);
            return readIntList();
        }
    }

    private static List<Integer> getIntList() {
        return Arrays.stream(getStringNumbers())
            .map(String::trim)
            .map(Integer::valueOf)
            .collect(toList());
    }

    private static String[] getStringNumbers() {
        return readLine().split(NUMBER_SPLIT_REGEX);
    }

    private InputUtil() {
    }
}
