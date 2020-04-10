package lotto.utils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringParser {

    private static final String DELIMETER = ",";

    public static List<String> splitText(String text) {
        return Stream.of(text.split(DELIMETER))
                .map(String::trim)
                .collect(Collectors.toList());
    }
}
