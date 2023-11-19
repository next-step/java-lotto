package lotto.domain;

import lotto.service.ValidationCheck;

import java.util.*;
import java.util.stream.Collectors;

public class WinningNumbers {
    private final Set<Integer> winningNumbers;

    public WinningNumbers(String winningNumbers) {
        ValidationCheck.validateWinningNumbersLength(winningNumbers);
        this.winningNumbers = Arrays.asList(winningNumbers.trim().split(","))
                .stream()
                .map(Integer::parseInt)
                .collect(Collectors.toSet());
        ValidationCheck.validateNoDuplicateWinningNumbers(getWinningNumbers());
    }

    public final Set<Integer> getWinningNumbers() {
        return new HashSet<>(winningNumbers);
    }
}
