package com.cheolhyeonpark.lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class WinningNumbers {

    private final List<Integer> winningNumbers;

    public WinningNumbers(String input) {
        this.winningNumbers = getWinningNumbers(input);
    }

    private List<Integer> getWinningNumbers(String input) {
        return Arrays.stream(input.replaceAll(" ", "")
                .split(",")).map(Integer::parseInt).collect(Collectors.toList());
    }

    public boolean anyMatch(int number) {
        return winningNumbers.stream().anyMatch(Predicate.isEqual(number));
    }
}
