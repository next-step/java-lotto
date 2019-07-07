package lotto.domain.ticket;

import lotto.common.Csv;
import lotto.common.PositiveNumber;

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
                .map(csv -> LottoTicket.ofManual(LottoNumbers.of(csv.getCsvLong())))
                .collect(Collectors.toList()));
    }

    public List<LottoTicket> findAll() {
        return new ArrayList<>(lottoTickets);
    }

    public PositiveNumber count() { return PositiveNumber.of(lottoTickets.size()); }

    public PositiveNumber getNumberOfAutoTickets() {
        return PositiveNumber.of(lottoTickets.stream()
                .filter(LottoTicket::isAutoTicket)
                .count());
    }

    public PositiveNumber getNumberOfManualTickets() {
        return PositiveNumber.of(lottoTickets.stream()
                .filter(LottoTicket::isManualTicket)
                .count());
    }
}
