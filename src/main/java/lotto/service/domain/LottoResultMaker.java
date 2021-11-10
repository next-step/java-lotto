package lotto.service.domain;

import lotto.service.domain.types.Rank;
import lotto.service.model.LottoResult;
import lotto.service.model.LottoTickets;

import java.util.Map;

public class LottoResultMaker {
    public LottoResult checkLottoResult(LottoTickets purchaseLottoTickets, WinningLottoTicket winningLottoTicket) {
        Map<Rank, Integer> countOfWinningByRank = purchaseLottoTickets.countOfWinningByRank(winningLottoTicket);
        return LottoResult.from(countOfWinningByRank);
    }
}
