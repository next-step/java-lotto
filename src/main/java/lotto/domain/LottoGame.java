package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoGame {
    private final LottoTickets lottoTickets;

    public LottoGame(LottoTickets lottoTickets) {
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
