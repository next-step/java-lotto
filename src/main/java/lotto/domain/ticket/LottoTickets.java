package lotto.domain.ticket;

import lotto.common.Csv;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTickets {
    private List<LottoTicket> lottoTickets;

    private LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public static LottoTickets of(List<LottoTicket> lottoTickets) {
        return new LottoTickets(lottoTickets);
    }

    public static LottoTickets ofManual(List<Csv> manualTickets) {
        return LottoTickets.of(manualTickets.stream()
                .map(csv -> LottoTicket.of(csv.getCsvLong()))
                .collect(Collectors.toList()));
    }

    public List<LottoTicket> findAll() {
        return new ArrayList<>(lottoTickets);
    }

    public long count() { return lottoTickets.size(); }
}
