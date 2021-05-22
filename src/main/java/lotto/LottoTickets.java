package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoTickets {

    private final List<LottoTicket> lottoTickets;

    private final LottoResult lottoResult = new LottoResult();

    public LottoTickets(int count) {
        this.lottoTickets = issueTickets(count);
    }

    public LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    private List<LottoTicket> issueTickets(int count) {
        List<LottoTicket> ticketList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            ticketList.add(LottoTicketGenerator.start().extract());
        }
        return ticketList;
    }

    public int counts() {
        return lottoTickets.size();
    }

    public LottoResult matchingResultWith(WinningNumbers winningNumbers) {
        Map<MatchStatus, Integer> result = new HashMap<>();
        for (LottoTicket ticket : lottoTickets) {
            MatchStatus status = ticket.matchingStatusWith(winningNumbers);
            lottoResult.updateValue(status);
        }
        return lottoResult;
    }
}
