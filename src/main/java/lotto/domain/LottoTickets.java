package lotto.domain;

import java.util.Collections;
import java.util.Set;

public class LottoTickets {
    private final Set<LottoTicket> lottoTickets;

    private LottoTickets(Set<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public static LottoTickets of(Set<LottoTicket> lottoTickets) {
        return new LottoTickets(lottoTickets);
    }

    public Set<LottoTicket> getLottoTickets() {
        return Collections.unmodifiableSet(lottoTickets);
    }
}
