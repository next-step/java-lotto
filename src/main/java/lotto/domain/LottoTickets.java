package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTickets {
    private final List<LottoTicket> lottoTickets;

    public LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public List<Long> matchesLottoTicketCount(List<Integer> winningNumbers) {
        return lottoTickets.stream()
                .map(lottoTicket -> lottoTicket.matchesLottoNumberCount(winningNumbers))
                .collect(Collectors.toList());
    }

    public List<LottoTicket> getLottoTickets() {
        return Collections.unmodifiableList(lottoTickets);
    }

    public int size() {
        return this.lottoTickets.size();
    }
}
