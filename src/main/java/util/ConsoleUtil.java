package util;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class ConsoleUtil {
    public static List<Integer> changeWinNumberToInteger(String winNumber) {
        return Arrays.stream(winNumber.split(","))
                .map(Integer::valueOf)
                .collect(toList());
    }
}
