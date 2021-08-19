package lotto.model;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class WinningIdentifier {

    private final LottoTicket winningTicket;

    public WinningIdentifier(LottoTicket winningTicket) {
        this.winningTicket = winningTicket;
    }

    public Rank checkWinning(LottoTicket lottoTicket) {
        return Rank.of(lottoTicket.compareTicket(winningTicket));
    }

    public WinningReport checkTicketsWinning(List<LottoTicket> lottoTickets) {
        return lottoTickets.stream()
                .map(ticket -> Rank.of(ticket.compareTicket(winningTicket)))
                .collect(collectingAndThen(toList(), WinningReport::new));
    }
}
