package lotto.util;

import lotto.domain.Lotto;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Parser {
    private Parser() {}

    public static Lotto parseWinningNumbers(String input) {
        return new Lotto(Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList()));
    }
}
