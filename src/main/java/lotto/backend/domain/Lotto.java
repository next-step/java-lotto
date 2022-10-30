package lotto.backend.domain;

import java.util.List;

public class Lotto {

    private LottoTickets lottoTickets;

    public LottoTickets buy(int paidMoney) {
        this.lottoTickets = LottoTicket.of(new Money(paidMoney));
        return lottoTickets;
    }

    public LottoResult match(List<Integer> winningNumber, int bonus) {
        return LottoResult.of(WinningLotto.of(winningNumber, bonus), lottoTickets);
    }
}
