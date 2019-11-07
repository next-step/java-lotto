package lottery.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lottery.LottoResult;
import lottery.LottoResults;

public class LottoTickets {

    private static final String TICKET_DELIMITER = "\n";
    private List<LottoTicket> lottoTickets;

    public LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public int size() {
        return lottoTickets.size();
    }

    public LottoResults match(List<Integer> winNumbers, int bonusNumber) {
        List<LottoResult> results = new ArrayList<>();
        for (LottoTicket ticket : lottoTickets) {
            results.add(new LottoResult(ticket.match(winNumbers).size(), ticket.isBonusMatched(bonusNumber)));
        }
        return new LottoResults(results);
    }

    @Override
    public String toString() {
        return lottoTickets.stream()
            .map(LottoTicket::toString)
            .collect(Collectors.joining(TICKET_DELIMITER));
    }
}
