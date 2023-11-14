package lotto.util;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringParser {

    private static final String DEFAULT_PATTERN = ", ";

    public static List<Integer> parseToInts(String text) {
        return Stream.of(text.split(DEFAULT_PATTERN))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

}
