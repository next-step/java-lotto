package step2.model;

import java.util.Collections;
import java.util.List;

public class LottoTickets {

    private final List<LottoTicket> lottoTickets;

    private LottoTickets(List<LottoTicket> lottoTickets) {
        if (lottoTickets == null) {
            throw new IllegalArgumentException();
        }

        this.lottoTickets = Collections.unmodifiableList(lottoTickets);
    }

    public static LottoTickets create(List<LottoTicket> lottoTickets) {
        return new LottoTickets(lottoTickets);
    }

    public int getTicketCount() {
        return this.lottoTickets.size();
    }

    public List<LottoTicket> getLottoTickets() {
        return this.lottoTickets;
    }

    public MatchResult calculateMatchResult(WinningNumbers winningNumbers) {
        MatchResult matchResult = MatchResult.create();

        this.lottoTickets.stream()
                .map(winningNumbers::calculateMatchRank)
                .forEach(matchResult::plusCount);

        return matchResult;
    }
}
