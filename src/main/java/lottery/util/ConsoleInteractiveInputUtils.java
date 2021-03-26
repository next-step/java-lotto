package lottery.util;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ConsoleInteractiveInputUtils {

    private ConsoleInteractiveInputUtils() {
    }

    public static int getInt(String message) {
        printMessage(message);

        return Integer.parseInt(getUserInput());
    }

    public static List<List<Integer>> getIntegerLists(String message, String delimiter, int length) {
        printMessage(message);

        return IntStream.range(0, length)
                        .mapToObj(ignored -> convertIntegerList(getUserInput(), delimiter))
                        .collect(Collectors.toList());
    }

    public static List<Integer> getListOfInteger(String message, String delimiter) {
        printMessage(message);

        return convertIntegerList(getUserInput(), delimiter);
    }

    private static void printMessage(String message) {
        System.out.println(message);
    }

    private static String getUserInput() {
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        return scanner.next();
    }

    private static List<Integer> convertIntegerList(String str, String delimiter) {
        return Arrays.stream(str.split(delimiter))
                     .map(String::trim)
                     .map(Integer::parseInt)
                     .collect(Collectors.toList());
    }

}
