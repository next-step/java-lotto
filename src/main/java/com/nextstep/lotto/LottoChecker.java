package com.nextstep.lotto;

import java.util.List;

public class LottoChecker {
    private List<Integer> winNumbers;

    public LottoChecker(List<Integer> winNumbers) {
        this.winNumbers = winNumbers;
    }

    public int checkCount(List<Integer> collectNumbers) {
        return (int)collectNumbers.stream()
                .filter(collectNumber -> winNumbers.contains(collectNumber))
                .count();
    }
}
