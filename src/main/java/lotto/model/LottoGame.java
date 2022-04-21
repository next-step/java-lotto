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

    public RankResults start(LottoNumber bonusNumber) {
        winningTicket.validateBonusNumber(bonusNumber);
        Ranks ranks = new Ranks(lottoTickets.getRanks(winningTicket, bonusNumber));
        List<RankResult> rankResults = ranks.groupBy();
        return new RankResults(rankResults);
    }

}
