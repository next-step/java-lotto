package lotto.domain;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Parser {
    private Parser() {}

    public static Lotto parseWinningNumbers(String input) {
        return Lotto.from(Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList()));
    }
}
