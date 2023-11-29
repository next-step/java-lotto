package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTickets {
    private List<LottoTicket> lottoTickets = new ArrayList<>();

    public LottoTickets(int ticketQuantity) {
        for (int i = 0; i < ticketQuantity; i++) {
            lottoTickets.add(new LottoTicket());
        }
    }

    public LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public List<LottoTicket> getLottoTickets() {
        return Collections.unmodifiableList(lottoTickets);
    }

    public List<Rank> checkTickets(LottoChecker lottoChecker) {
        return lottoTickets.stream()
            .map(lottoChecker::check)
            .collect(Collectors.toList());
    }
}
