package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoRound {
    private final List<LottoTicket> lottoTickets;

    public LottoRound(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public List<LottoResult> finishRound(WinningLotto winingLotto) {
        List<LottoResult> result = new ArrayList<>();
        for (LottoTicket ticket : lottoTickets) {
            result.add(winingLotto.match(ticket));
        }
        return result;
    }
}
