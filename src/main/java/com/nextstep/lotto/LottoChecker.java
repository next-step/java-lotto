package com.nextstep.lotto;

import java.util.List;

public class LottoChecker {
    private LottoChecker(){}

    public static int checkCount(List<Integer> winningNumbers, List<Integer> collectNumbers) {
        return (int)collectNumbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }
}
