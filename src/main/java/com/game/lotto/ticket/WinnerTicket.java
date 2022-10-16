package com.game.lotto.ticket;

import com.game.lotto.number.LottoNumberGenerator;

import java.util.List;

public class WinnerTicket {

    private final List<Integer> numbers;
    private final int bonusNumber;

    public WinnerTicket(LottoNumberGenerator lottoNumberGenerator, int bonusNumber) {
        this.numbers = lottoNumberGenerator.generateNumbers();
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
