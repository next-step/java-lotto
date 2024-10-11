package lotto.domain.ticket;

import lotto.domain.winning.WinningTickets;

import java.util.List;
import java.util.stream.Collectors;

public class LottoTickets {
    private final List<LottoTicket> lottoTickets;

    public LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public WinningTickets findWinning(String[] winningNumbers) {
        return new WinningTickets(
            lottoTickets.stream()
                        .collect(Collectors.groupingBy(lottoTicket -> lottoTicket.findMatchCount(winningNumbers))));
    }

    public int getLottoTicketsSize() {
        return lottoTickets.size();
    }

}
