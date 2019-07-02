package com.java.lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class WinningNumbers {
    private List<Integer> winningNumbers;
    private final Integer bonusNumber;

    public WinningNumbers(String winningNumbers, Integer bonusNumber) {
        this.winningNumbers = LottoNumbersGenerator.manualNumbersGenerator(winningNumbers);
        this.bonusNumber = bonusNumber;
    }

    public boolean isBonusNumber(Integer number) {
        return this.bonusNumber.equals(number);
    }

    public int matchCount(LottoTicket lottoTicket) {
        return (int) winningNumbers.stream()
                .filter(number -> lottoTicket.isMatchNumber(number))
                .count();
    }

}
