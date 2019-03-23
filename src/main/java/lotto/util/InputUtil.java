package lotto.util;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputUtil {
    public static List<Integer> convertToInt(String[] strings) {
        return Stream.of(strings)
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }

    public static String[] split(String str) {
        return str.split(", ");
    }
}
