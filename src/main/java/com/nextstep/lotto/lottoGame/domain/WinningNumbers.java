package com.nextstep.lotto.lottoGame.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumbers {
    private final Set<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningNumbers(final List<Integer> winningNumbers, final int bonusNumber) {
        this.winningNumbers = new HashSet<>(winningNumbers);
        this.bonusNumber = bonusNumber;
    }

    public int getMatchCount(Set<Integer> lottoNumbers) {
        Long matchCount = lottoNumbers.stream()
                .filter(winningNumbers::contains)
                .count();
        return matchCount.intValue();
    }

    public boolean isMatchBonus(Set<Integer> lottoNumbers) {
        return lottoNumbers.contains(bonusNumber);
    }
}
