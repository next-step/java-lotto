package lotto.view;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputView {

    public static int promptInt(String message) {
        System.out.println(message);
        return getScanner().nextInt();
    }

    public static String promptString(String message) {
        System.out.println(message);
        return getScanner().nextLine();
    }

    public static String getLineString() {
        return getScanner().nextLine();
    }

    public static List<String> promptMultiLines(String message, int numOfLine) {
        System.out.println(message);

        return IntStream.range(0, numOfLine)
                .mapToObj(i -> getLineString())
                .collect(Collectors.toList());
    }

    private static Scanner getScanner() {
        return new Scanner(System.in);
    }
}