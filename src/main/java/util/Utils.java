package util;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class Utils {

    private Utils() {
    }

    public static List<Integer> convertToNumbers(final String[] stringNumbers) {
        return Stream.of(stringNumbers)
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }
}
