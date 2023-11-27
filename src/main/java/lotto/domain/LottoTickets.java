package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import lotto.domain.strategy.GenerateStrategy;

public class LottoTickets {
    private final List<LottoTicket> lottoTickets = new ArrayList<>();

    public LottoTickets(int ticketQuantity, GenerateStrategy strategy) {
        for (int i = 0; i < ticketQuantity; i++) {
            lottoTickets.add(new LottoTicket(strategy));
        }
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
