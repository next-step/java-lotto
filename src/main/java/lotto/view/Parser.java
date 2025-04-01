package lotto.view;

import lotto.domain.WinningNumbers;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Parser {
    public static WinningNumbers parseWinningNumbers(String input) {
        return new WinningNumbers(parseNumberSet(input));
    }

    public static Set<Integer> parseNumberSet(String input) {
        String[] tokens = input.split(",");

        return Arrays.stream(tokens)
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toSet());
    }
}
