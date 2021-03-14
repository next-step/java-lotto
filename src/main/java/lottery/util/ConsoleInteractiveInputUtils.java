package lottery.util;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ConsoleInteractiveInputUtils {

    private ConsoleInteractiveInputUtils() {
    }

    public static int getInt(String message) {
        printMessage(message);

        return Integer.parseInt(getUserInput());
    }

    public static List<String> getListOfString(String message, String delimiter) {
        printMessage(message);

        return Arrays.stream(getUserInput().split(delimiter))
                     .map(String::trim)
                     .collect(Collectors.toList());
    }

    public static List<Integer> getListOfInteger(String message, String delimiter) {
        printMessage(message);

        return Arrays.stream(getUserInput().split(delimiter))
                     .map(String::trim)
                     .map(Integer::parseInt)
                     .collect(Collectors.toList());
    }

    private static void printMessage(String message) {
        System.out.println(message);
    }

    private static String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

}
