package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Extractor {
    private static final String delimiter = " ";

    private Extractor() {}

    public static List<Long> extract_numbers(String input) {
        List<String> tokens = split(input);
        return IntStream.range(0, tokens.size())
                .filter(i -> i % 2 == 0)
                .mapToObj(tokens::get)
                .map(Long::parseLong)
                .collect(Collectors.toList());
    }

    public static List<Operator> extract_operators(String input) {
        List<String> tokens = split(input);
        return IntStream.range(0, tokens.size())
                .filter(i -> i % 2 != 0)
                .mapToObj(tokens::get)
                .map(Operator::fromValue)
                .collect(Collectors.toList());
    }

    private static List<String> split(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException();
        }
        return Arrays.asList(input.split(delimiter));
    }
}
