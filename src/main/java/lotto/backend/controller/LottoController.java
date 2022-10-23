package lotto.backend.controller;

import lotto.backend.domain.LottoStatistics;
import lotto.backend.domain.LottoTicket;
import lotto.backend.domain.LottoTickets;

import java.util.Arrays;

public class LottoController {
    private LottoTickets lottoTickets;

    public LottoTickets buy(int money) {
        this.lottoTickets = LottoTicket.of(money);
        return lottoTickets;
    }

    public LottoStatistics match(String winningNumber) {
        LottoTicket winningLotto = LottoTicket.of(Arrays.stream(winningNumber.split(","))
                .mapToInt(Integer::parseInt)
                .toArray());
        return new LottoStatistics(winningLotto, lottoTickets);
    }
}
