package lotto.service.domain;

import lotto.service.domain.types.Rank;
import lotto.service.model.LottoResult;
import lotto.service.model.LottoTickets;

import java.util.Map;

public class LottoResultMaker {
    public LottoResult checkLottoResult(LottoTickets purchaseLottoTickets, WinningLottoNumber winningLottoNumber) {
        Map<Rank, Integer> countOfWinningByRank = purchaseLottoTickets.countOfWinningByRank(winningLottoNumber);
        return LottoResult.from(countOfWinningByRank);
    }
}
