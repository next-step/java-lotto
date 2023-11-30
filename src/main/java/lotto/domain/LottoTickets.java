package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import lotto.domain.strategy.LottoGenerator;

public class LottoTickets {
    private final List<LottoTicket> lottoTickets;

    public LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public LottoTickets(LottoGenerator strategy) {
        this.lottoTickets = strategy.generate();
    }

    public LottoTickets add(LottoTickets lottoTickets) {
        this.lottoTickets.addAll(lottoTickets.getLottoTickets());
        return this;
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
