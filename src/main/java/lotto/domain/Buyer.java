package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Buyer {
    private final List<LottoTicket> lottoTickets;

    public static Buyer of(Money money) {
        return new Buyer(LottoMachine.createLottoTickets(money));
    }

    public static Buyer of(Money money, LottoTicketForms lottoTicketForms) {
        return new Buyer(LottoMachine.createLottoTickets(money, lottoTicketForms));
    }

    public static Buyer of(List<LottoTicket> lottoTickets) {
        return new Buyer(lottoTickets);
    }

    private Buyer(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }

    public BuyerResult getResult(WinningLotto winningLotto) {
        return BuyerResult.of(getWinningResult(winningLotto));
    }

    private List<Rank> getWinningResult(WinningLotto winningLotto) {
        return lottoTickets.stream()
                .map(lottoTicket -> lottoTicket.checkWinning(winningLotto))
                .collect(Collectors.toList());
    }
}
