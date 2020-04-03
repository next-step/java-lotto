package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Buyer {
    private List<LottoTicket> lottoTickets;

    public Buyer() {
    }

    public Buyer(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public List<LottoTicket> buyLottoTickets(Money money) {
        lottoTickets = LottoMachine.pay(money);
        return lottoTickets;
    }

    public BuyerResult getResult(WinningLotto winningLotto) {
        return new BuyerResult(getWinningResult(winningLotto), lottoTickets.size());
    }

    private List<Rank> getWinningResult(WinningLotto winningLotto) {
        return lottoTickets.stream()
                .map(lottoTicket -> lottoTicket.checkWinning(winningLotto))
                .collect(Collectors.toList());
    }
}
