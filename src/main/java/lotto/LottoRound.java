package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoRound {
    private final List<LottoTicket> lottoTickets;

    public LottoRound(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public List<LottoResult> finishRound(LottoTicket winningTicket) {
        List<LottoResult> result = new ArrayList<>();
        for (LottoTicket ticket : lottoTickets) {
            result.add(LottoResult.match(ticket, winningTicket));
        }
        return result;
    }
}
