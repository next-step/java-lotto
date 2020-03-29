package lotto.domain;

import java.util.List;

public class Buyer {
    private List<LottoTicket> lottoTickets;

    public Buyer() {
    }

    public Buyer(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public List<LottoTicket> buyLottoTickets(long money) {
        lottoTickets = LottoMachine.pay(money);
        return lottoTickets;
    }

    public BuyerResult getResult(LottoTicket winningTicket) {
        return new BuyerResult(lottoTickets, winningTicket);
    }
}
