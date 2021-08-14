package lotto.model;

import java.util.List;
import java.util.stream.Collectors;

public class WinningIdentifier {

    private final LottoTicket winningTicket;

    public WinningIdentifier(LottoTicket winningTicket) {
        this.winningTicket = winningTicket;
    }

    public Rank checkWinning(LottoTicket lottoTicket) {
        return Rank.of(lottoTicket.compareTicket(winningTicket));
    }

    public WinningReport checkTicketsWinning(List<LottoTicket> lottoTickets) {
        List<Rank> ranks = lottoTickets.stream()
                .map(ticket -> Rank.of(ticket.compareTicket(winningTicket)))
                .collect(Collectors.toList());
        return new WinningReport(ranks);
    }
}
