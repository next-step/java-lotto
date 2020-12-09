package lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTickets {

    private final List<LottoTicket> lottoTickets;

    public LottoTickets(final List<LottoTicket> lottoTickets) {
        this.lottoTickets = Collections.unmodifiableList(lottoTickets);
    }

    public static LottoTickets of(final List<LottoTicket> lottoTickets) {
        return new LottoTickets(lottoTickets);
    }

    public List<Rank> match(final LottoTicket winning) {
        return lottoTickets.stream()
                .map(lottoTicket -> lottoTicket.match(winning))
                .collect(Collectors.toList());
    }

    public int count() {
        return lottoTickets.size();
    }
}
