package lotto.domain;

import lotto.matcher.LottoMatcher;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTickets {
    private final List<LottoTicket> lottoTickets;

    public LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = Collections.unmodifiableList(lottoTickets);
    }

    public List<LottoTicket> getLottoTickets() {
        return this.lottoTickets;
    }

    public List<LottoMatcher> findLottoMatchResults(LottoWinnerNumber lottoWinnerNumber) {
        List<LottoMatcher> lottoMatchers = new ArrayList<>();
        for (LottoTicket lottoTicket : lottoTickets) {
            lottoMatchers.add(lottoTicket.findLottoMatchResult(lottoWinnerNumber));
        }
        return lottoMatchers;
    }

    public int getPurchaseTicketCount() {
        return this.lottoTickets.size();
    }
}
