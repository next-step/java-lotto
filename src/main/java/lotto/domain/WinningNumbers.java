package lotto.domain;

import lotto.service.ValidationCheck;

import java.util.*;
import java.util.stream.Collectors;

public class WinningNumbers {
    private final Set<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningNumbers(String winningNumbers, int bonusNumber) {
        ValidationCheck.validateWinningNumbersLength(winningNumbers);
        this.winningNumbers = Arrays.asList(winningNumbers.trim().split(","))
                .stream()
                .map(Integer::parseInt)
                .collect(Collectors.toSet());
        ValidationCheck.validateNoDuplicateBonusNumbers(getWinningNumbers(), bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public final Set<Integer> getWinningNumbers() {
        return new HashSet<>(winningNumbers);
    }

    public final int getBonusNumber() {
        return bonusNumber;
    }
}