package lotto.service;

import lotto.domain.*;

public class RankingService {

    private static final int MIN_EXPECT = 3;
    private static final int MAX_EXPECT = 6;

    public LottoResults calculateMatchHits(WinningNumbers winningNumbers, LottoTickets lottoTickets, RankingCalculator calculator) {

        LottoResults lottoResults = new LottoResults();

        for (int i = MIN_EXPECT; i <= MAX_EXPECT; i++) {
            LottoResult lottoResult = calculator.calculate(winningNumbers, lottoTickets, i);
            lottoResults.add(lottoResult);
        }

        return lottoResults;
    }
}
