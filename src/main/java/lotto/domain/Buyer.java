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

    public BuyerResult getResult(LottoNumbers winningNumbers, LottoNumber bonusNumber) {
        return new BuyerResult(getWinningResult(winningNumbers, bonusNumber), lottoTickets.size());
    }

    private List<Rank> getWinningResult(LottoNumbers winningNumbers, LottoNumber bonusNumber) {
        List<LottoTicketResult> winningLottoTicketResults = lottoTickets.stream()
                .map(lottoTicket -> lottoTicket.checkWinning(winningNumbers, bonusNumber))
                .filter(LottoTicketResult::isWinning)
                .collect(Collectors.toList());

        return winningLottoTicketResults.stream()
                .map(Rank::of)
                .collect(Collectors.toList());
    }
}
