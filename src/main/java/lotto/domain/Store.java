package lotto.domain;

import lotto.domain.lottogenerator.LottoGenerator;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Store {

    private final List<LottoTicket> lottoTickets;

    public Store(final LottoGenerator lottoGenerator) {
        this.lottoTickets = lottoGenerator.create();
    }

    public Store(final List<Store> lottoTickets) {
        this.lottoTickets = lottoTickets.stream()
                .flatMap(lottoTicket -> lottoTicket.getLottoTickets().stream()).collect(Collectors.toList());
    }

    public List<Rank> match(final WinningLotto winningLotto) {
        return lottoTickets.stream()
                .map(winningLotto::match)
                .collect(Collectors.toList());
    }

    public int sizeOfLottoTickets() {
        return this.lottoTickets.size();
    }

    public List<LottoTicket> getLottoTickets() {
        return Collections.unmodifiableList(this.lottoTickets);
    }

}
