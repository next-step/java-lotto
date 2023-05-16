package lotto.model;

import java.util.List;
import java.util.Set;

public class LottoGame {
    private LottoTickets lottoTickets;
    private LottoTicket winTicket;

    public LottoGame(LottoTickets lottoTickets, LottoTicket winTicket) {
        this.lottoTickets = lottoTickets;
        this.winTicket = winTicket;
    }

    public LottoResult playLotto() {
        List<Rank> rankList = lottoTickets.getRankings(winTicket);
        return new LottoResult(rankList);
    }
}
