package com.java.lotto.domain;

public class WinningTicket {
    private LottoTicket winningTicket;
    private final Integer bonusNumber;

    public WinningTicket(String winningTicket, Integer bonusNumber) {
        this.winningTicket = new LottoTicket(LottoNumbersGenerator.manualNumbersGenerator(winningTicket));
        this.bonusNumber = bonusNumber;
    }

    public boolean isBonusNumber(Integer number) {
        return this.bonusNumber.equals(number);
    }

    public int matchCount(LottoTicket lottoTicket) {
        return (int) winningTicket.numbersStream()
                .filter(number -> lottoTicket.isMatchNumber(number))
                .count();
    }

}
