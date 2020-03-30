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

    public List<LottoTicket> buyLottoTickets(long money) {
        lottoTickets = LottoMachine.pay(money);
        return lottoTickets;
    }

    public BuyerResult getResult(LottoTicket winningTicket, LottoNumber bonusNumber) {
        return new BuyerResult(getWinningResult(winningTicket, bonusNumber), lottoTickets.size());
    }

    private List<Rank> getWinningResult(LottoTicket winningTicket, LottoNumber bonusNumber) {
        List<LottoTicketResult> winningLottoTicketResults = lottoTickets.stream()
                .map(lottoTicket -> lottoTicket.checkWinning(winningTicket, bonusNumber))
                .filter(result -> result.getMatchCount() >= LottoTicket.WINNING_MIN_COUNT)
                .collect(Collectors.toList());

        return winningLottoTicketResults.stream()
                .map(Rank::findByLottoTicketResult)
                .collect(Collectors.toList());
    }
}
