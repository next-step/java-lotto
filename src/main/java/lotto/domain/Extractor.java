package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Extractor {
    private final String delimiter = " ";

    public List<Integer> extract_numbers(String input) {
        List<String> tokens = split(input);
        return IntStream.range(0, tokens.size())
                .filter(i -> i % 2 == 0)
                .mapToObj(tokens::get)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public List<String> extract_operators(String input) {
        List<String> tokens = split(input);
        return IntStream.range(0, tokens.size())
                .filter(i -> i % 2 != 0)
                .mapToObj(tokens::get)
                .map(this::checkOperator)
                .collect(Collectors.toList());
    }

    private List<String> split(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException();
        }
        return Arrays.asList(input.split(delimiter));
    }

    private String checkOperator(String op) {
        if (!op.equals("+") && !op.equals("-") && !op.equals("/") && !op.equals("*")) {
            throw new IllegalArgumentException();
        }
        return op;
    }
}
