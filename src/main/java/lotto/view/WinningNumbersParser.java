package lotto.view;

import lotto.domain.WinningNumbers;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class WinningNumbersParser {
    public static WinningNumbers parse(String input) {
        String[] tokens = input.split(",");
        Set<Integer> numbers = Arrays.stream(tokens)
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toSet());

        return new WinningNumbers(numbers);
    }
}
