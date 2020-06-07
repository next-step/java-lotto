package lotto.domain.ticket;

import lotto.domain.result.LottoResult;
import lotto.domain.result.WinningTicket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class LottoTickets {
    private final List<LottoTicket> lottoTickets;

    public LottoTickets(final List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public LottoResult getLottoResult(final WinningTicket winningTicket) {
        return lottoTickets.stream()
                .map(winningTicket::checkLottoNumbers)
                .collect(collectingAndThen(toList(), LottoResult::new));
    }

    public LottoTickets combine(final LottoTickets lottoTickets) {
        List<LottoTicket> allLottoTickets = new ArrayList<>(this.lottoTickets);
        allLottoTickets.addAll(lottoTickets.getLottoTickets());
        return new LottoTickets(allLottoTickets);
    }

    public List<LottoTicket> getLottoTickets() {
        return Collections.unmodifiableList(lottoTickets);
    }

    public int count() {
        return lottoTickets.size();
    }

    @Override
    public String toString() {
        return String.valueOf(lottoTickets);
    }
}
