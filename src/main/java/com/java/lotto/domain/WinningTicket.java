package com.java.lotto.domain;

import java.util.List;

public class WinningTicket {
    private List<Integer> winningTicket;
    private final Integer bonusNumber;

    public WinningTicket(String winningTicket, Integer bonusNumber) {
        this.winningTicket = LottoNumbersGenerator.manualNumbersGenerator(winningTicket);
        this.bonusNumber = bonusNumber;
    }

    public boolean isBonusNumber(Integer number) {
        return this.bonusNumber.equals(number);
    }

    public int matchCount(LottoTicket lottoTicket) {
        return (int) winningTicket.stream()
                .filter(number -> lottoTicket.isMatchNumber(number))
                .count();
    }

}
