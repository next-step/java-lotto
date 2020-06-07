package dev.dahye.lotto.service;

import dev.dahye.lotto.domain.LottoMoney;
import dev.dahye.lotto.domain.LottoTickets;

public class LottoMachine {
    private LottoTickets lottoTickets;

    public LottoMachine(LottoMoney lottoMoney) {
        int countOfLotto = lottoMoney.calculateCountOfLotto();
        lottoTickets = LottoTickets.autoIssued(countOfLotto);
    }

    public LottoTickets getLottoTickets() {
        return lottoTickets;
    }
}
