package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Store {

    private final List<LottoTicket> lottoTickets;

    public Store(final List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public Store add(final Store store) {
        return new Store(Stream.concat(this.lottoTickets.stream(), store.lottoTickets.stream())
                .collect(Collectors.toList()));
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
