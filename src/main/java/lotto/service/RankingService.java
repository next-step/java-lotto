package lotto.service;

import lotto.domain.LottoResult;
import lotto.domain.LottoResults;
import lotto.domain.LottoNumber;
import lotto.domain.LottoTickets;
import lotto.domain.RankingCalculator;

import java.util.List;

public class RankingService {

    private static final int MIN_EXPECT = 3;
    private static final int MAX_EXPECT = 6;

    public LottoResults calculateMatchHits(List<LottoNumber> lastWeekWinning, LottoTickets lottoTickets, RankingCalculator calculator) {

        LottoResults lottoResults = new LottoResults();

        for (int i = MIN_EXPECT; i <= MAX_EXPECT; i++) {
            LottoResult lottoResult = calculator.calculate(lastWeekWinning, lottoTickets, i);
            lottoResults.add(lottoResult);
        }

        return lottoResults;
    }
}
