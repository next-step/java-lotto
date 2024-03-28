package ui;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class LottoInputUtils {

    public static List<Integer> toNumberList(String input) {
        if (isBlank(input)) {
            throw new IllegalArgumentException();
        }
        return toInts(splitInput(input));
    }

    private static boolean isBlank(String line) {
        return line == null || line.isBlank();
    }

    private static String[] splitInput(String line) {
        return line.split(",");
    }

    private static List<Integer> toInts(String[] values) {
        return Arrays.stream(values)
                .map(it -> Integer.parseInt(it.trim()))
                .collect(Collectors.toList());

    }
}
