package lotto.model;

import java.util.List;
import java.util.Set;

public class LottoGame {
    private LottoTickets lottoTickets;
    private WinningTicket winTicket;

    public LottoGame(LottoTickets lottoTickets, WinningTicket winTicket) {
        this.lottoTickets = lottoTickets;
        this.winTicket = winTicket;
    }

    public LottoResult playLotto() {
        List<Rank> rankList = lottoTickets.getRankings(winTicket);
        return new LottoResult(rankList);
    }
}
