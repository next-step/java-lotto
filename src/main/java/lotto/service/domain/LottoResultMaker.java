package lotto.service.domain;

import lotto.service.domain.types.Rank;
import lotto.service.model.LottoResult;
import lotto.service.model.LottoTickets;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LottoResultMaker {
    public LottoResult checkLottoResult(LottoTickets purchaseLottoTickets, WinningLottoNumber winningLottoNumber) {
        List<Integer> countOfMatchList = purchaseLottoTickets.getMatchingCountOfAllLottoTicket(winningLottoNumber);

        Map<Rank, Integer> countOfWinningByRank = countOfMatchList.stream()
                .map(countOfMatch -> Rank.convertRankByCountOfMatch(countOfMatch, false))
                .collect(Collectors.toMap(Function.identity(), value -> 1, Integer::sum));
        return LottoResult.from(countOfWinningByRank);
    }
}
