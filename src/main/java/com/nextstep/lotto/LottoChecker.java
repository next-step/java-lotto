package com.nextstep.lotto;

import java.util.List;

public class LottoChecker {
    private List<Integer> winningNumbers;

    public LottoChecker(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public int checkCount(List<Integer> collectNumbers) {
        return (int)collectNumbers.stream()
                .filter(collectNumber -> winningNumbers.contains(collectNumber))
                .count();
    }
}
