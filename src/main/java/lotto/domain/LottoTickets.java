package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoTickets {
    private final List<LottoTicket> lottoTickets;

    public LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public int lottoTicketCount() {
        return lottoTickets.size();
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }

    public LottoTickets union(LottoTickets randomLottoTickets) {
        return new LottoTickets(Stream.concat(lottoTickets.stream(), randomLottoTickets.getLottoTickets().stream())
                .collect(Collectors.toList()));
    }
}
