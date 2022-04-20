package lotto.model;

import java.util.List;

public class LottoGame {

    private final LottoTickets lottoTickets;

    private final WinningTicket winningTicket;

    public LottoGame(List<LottoTicket> lottoTickets, WinningTicket winningTicket) {
        this(new LottoTickets(lottoTickets), winningTicket);
    }

    public LottoGame(LottoTickets lottoTickets, WinningTicket winningTicket) {
        this.lottoTickets = lottoTickets;
        this.winningTicket = winningTicket;
    }

    public RankResults start() {
        Ranks ranks = new Ranks(lottoTickets.getRanks(winningTicket));
        List<RankResult> rankResults = ranks.groupBy();
        return new RankResults(rankResults);
    }

}
