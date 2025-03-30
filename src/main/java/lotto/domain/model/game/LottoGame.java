package lotto.domain.model.game;

import lotto.domain.model.lotto.LottoTicket;
import lotto.domain.model.lotto.WinningLottoTicket;

import java.util.List;

public class LottoGame {
    private final List<LottoTicket> lottoTickets;
    private final WinningLottoTicket winningLottoTicket;

    public LottoGame(final List<LottoTicket> lottoTickets, final WinningLottoTicket winningLottoTicket) {
        this.lottoTickets = lottoTickets;
        this.winningLottoTicket = winningLottoTicket;
    }

    public LottoGameResult draw() {
        LottoGameResult result = new LottoGameResult();
        for (LottoTicket lottoTicket : lottoTickets) {
            Rank rank = determineRank(lottoTicket);

            result.addResult(rank);
        }
        return result;
    }

    private Rank determineRank(final LottoTicket lottoTicket) {
        int matchCount = lottoTicket.countMatchingNumbers(winningLottoTicket);
        boolean hasBonusMatch = lottoTicket.contains(winningLottoTicket.getBonusNumber());

        return Rank.of(matchCount, hasBonusMatch);
    }
}
