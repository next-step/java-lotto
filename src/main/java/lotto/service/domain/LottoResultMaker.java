package lotto.service.domain;

import lotto.service.domain.types.Rank;
import lotto.service.model.LottoResult;
import lotto.service.model.LottoTickets;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LottoResultMaker {
    public LottoResult checkLottoResult(LottoTickets purchaseLottoTickets, LottoTicket winningLottoTicket) {
        List<Integer> matchingCountList = purchaseLottoTickets.getMatchingCountOfAllLottoTicket(winningLottoTicket);

        Map<Rank, Integer> countOfWinningByRank = matchingCountList.stream()
                .map(Rank::convertRankByCountOfMatch)
                .collect(Collectors.toMap(Function.identity(), value -> 1, Integer::sum));
        return LottoResult.from(countOfWinningByRank);
    }
}
