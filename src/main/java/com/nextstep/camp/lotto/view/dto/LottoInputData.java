package com.nextstep.camp.lotto.view.dto;

import com.nextstep.camp.lotto.domain.entity.LottoTickets;
import com.nextstep.camp.lotto.domain.vo.LottoAmount;
import com.nextstep.camp.lotto.domain.vo.LottoNumbers;
import com.nextstep.camp.lotto.domain.vo.WinningNumbers;

public class LottoInputData {
    private final LottoAmount lottoAmount;
    private final LottoTickets lottoTickets;
    private final WinningNumbers winningNumbers;

    private LottoInputData(LottoAmount lottoAmount, LottoTickets lottoTickets, WinningNumbers winningNumbers) {
        this.lottoAmount = lottoAmount;
        this.lottoTickets = lottoTickets;
        this.winningNumbers = winningNumbers;
    }

    public static LottoInputData of(LottoAmount lottoAmount, LottoTickets lottoTickets, WinningNumbers winningNumbers) {
        return new LottoInputData(lottoAmount, lottoTickets, winningNumbers);
    }

    public LottoAmount getLottoAmount() {
        return lottoAmount;
    }

    public LottoTickets getLottoTickets() {
        return lottoTickets;
    }

    public WinningNumbers getWinningNumbers() {
        return winningNumbers;
    }
}
