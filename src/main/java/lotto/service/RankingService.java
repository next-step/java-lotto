package lotto.service;

import lotto.domain.*;

public class RankingService {

    public LottoResults calculateResults(WinningNumbers winningNumbers,
                                         LottoTickets lottoTickets,
                                         RankingCalculator calculator) {

        LottoResults lottoResults = new LottoResults();

        for (Ranking ranking : Ranking.values()) {
            LottoResult lottoResult = calculator.calculate(winningNumbers, lottoTickets, ranking);
            lottoResults.add(lottoResult);
        }

        return lottoResults;
    }
}
