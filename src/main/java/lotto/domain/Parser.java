package lotto.domain;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {

    public static List<Integer> parse(String input) {

        return Arrays.stream(parseString(input))
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());
    }

    private static String[] parseString(String input) {
        return input.split(", ");
    }
}
