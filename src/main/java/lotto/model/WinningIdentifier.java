package lotto.model;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class WinningIdentifier {

    private final LottoTicket winningTicket;
    private final LottoNumber bonusNumber;

    public WinningIdentifier(LottoTicket winningTicket, LottoNumber bonusNumber) {
        this.winningTicket = winningTicket;
        this.bonusNumber = bonusNumber;
    }

    public WinningIdentifier(LottoTicket winningTicket) {
        this(winningTicket, null);
    }

    public Rank checkWinning(LottoTicket lottoTicket) {
        return Rank.of(lottoTicket.compareTicket(winningTicket), lottoTicket.contains(bonusNumber));
    }

    public WinningReport checkTicketsWinning(List<LottoTicket> lottoTickets) {
        return lottoTickets.stream()
                .map(ticket -> Rank.of(ticket.compareTicket(winningTicket), ticket.contains(bonusNumber)))
                .collect(collectingAndThen(toList(), WinningReport::new));
    }
}
