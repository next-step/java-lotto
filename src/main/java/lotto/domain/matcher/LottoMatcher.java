package lotto.domain.matcher;

import lotto.domain.machine.LottoTicket;
import lotto.domain.machine.LottoTickets;

import java.util.List;
import java.util.stream.Collectors;

public class LottoMatcher {
    private final LottoTickets lottoTickets;

    public LottoMatcher(LottoTickets lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public LottoGameResults match(WinningTicket winningTicket) {
        return new LottoGameResults(lottoTickets.checkRank(winningTicket));
    }

    public List<List<Integer>> getTicketSources() {
        return lottoTickets.getLottoTickets()
                .stream()
                .map(LottoTicket::toIntNumbers)
                .collect(Collectors.toList());
    }
}
