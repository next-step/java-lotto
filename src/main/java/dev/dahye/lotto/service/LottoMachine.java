package dev.dahye.lotto.service;

import dev.dahye.lotto.domain.LottoMoney;
import dev.dahye.lotto.domain.LottoTickets;

public class LottoMachine {
    private LottoTickets lottoTickets;
    private final LottoMoney lottoMoney;

    public LottoMachine(LottoMoney lottoMoney) {
        this.lottoMoney = lottoMoney;
        int countOfLotto = this.lottoMoney.calculateCountOfLotto();
        lottoTickets = LottoTickets.autoIssued(countOfLotto);
    }

    public LottoTickets getLottoTickets() {
        return lottoTickets;
    }
}
