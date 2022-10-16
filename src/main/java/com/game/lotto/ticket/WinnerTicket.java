package com.game.lotto.ticket;

import com.game.lotto.number.LottoNumber;
import com.game.lotto.number.LottoNumberGenerator;
import com.game.lotto.number.SelectedLottoNumbers;

public class WinnerTicket {

    private final SelectedLottoNumbers numbers;
    private final LottoNumber bonusNumber;

    public WinnerTicket(LottoNumberGenerator lottoNumberGenerator, LottoNumber bonusNumber) {
        this.numbers = lottoNumberGenerator.generateNumbers();
        this.bonusNumber = bonusNumber;
    }

    public SelectedLottoNumbers getNumbers() {
        return numbers;
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }
}
