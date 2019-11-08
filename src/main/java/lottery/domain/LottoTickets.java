package lottery.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lottery.dto.LottoResult;
import lottery.dto.LottoResults;

public class LottoTickets {

    private static final String TICKET_DELIMITER = "\n";
    private List<LottoTicket> lottoTickets;

    public LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public int size() {
        return lottoTickets.size();
    }

    public LottoResults match(LottoTicket winLottoTicket, LottoNumber bonusLottoNumber) {
        List<LottoResult> results = new ArrayList<>();
        for (LottoTicket ticket : lottoTickets) {
            results.add(new LottoResult(ticket.match(winLottoTicket).size(), ticket.isBonusMatched(bonusLottoNumber)));
        }
        return new LottoResults(results);
    }

    public void append(LottoTickets lottoTickets) {
        this.lottoTickets.addAll(lottoTickets.lottoTickets);
    }

    @Override
    public String toString() {
        return lottoTickets.stream()
            .map(LottoTicket::toString)
            .collect(Collectors.joining(TICKET_DELIMITER));
    }
}
