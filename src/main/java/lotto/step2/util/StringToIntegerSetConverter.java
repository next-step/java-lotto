package lotto.step2.util;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class StringToIntegerSetConverter {

    private static final String DELIMITER = ", ";

    private StringToIntegerSetConverter() {
        throw new IllegalStateException("Utility class");
    }

    public static Set<Integer> convert(final String text) {
        return Arrays.stream(text.split(DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toSet());
    }
}
