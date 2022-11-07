package lotto.domain;

import java.util.List;

public final class LottoStore {

    private final List<LottoTicket> sellable;

    public LottoStore(final List<LottoTicket> lottoTickets) {
        this.sellable = lottoTickets;
    }

    public void sellAllTo(final LottoCustomer customer) {
        sellable.forEach(customer::purchase);
    }

}
