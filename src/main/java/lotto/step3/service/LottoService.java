package lotto.step3.service;

import lotto.step3.domain.Lotteries;
import lotto.step3.domain.Lotto;
import lotto.step3.domain.LottoStatistics;
import lotto.step3.domain.LottoStore;

import java.util.List;
import java.util.Map;

public class LottoService {

    public Lotteries buyLotteries(int orderPrice) {
        LottoStore store = new LottoStore(orderPrice);
        return store.sellLotteries();
    }

    public Lotto createWinningNumbers(List<Integer> winningNumber) {
        return new Lotto(winningNumber);
    }

    public LottoStatistics createLottoStatistics(Lotteries lotteries, Lotto winningNumbers, int bonusBall) {
        return new LottoStatistics(lotteries, winningNumbers, bonusBall);
    }

    public Map<Integer, Integer> totalCountOfMatch(LottoStatistics lottoStatistics) {
        return lottoStatistics.totalCountOfMatch();
    }

    public boolean isSecondPrizeWinners(LottoStatistics lottoStatistics) {
        return lottoStatistics.isSecondPrizeWinners();
    }

    public int totalSecondPrizeWinners(LottoStatistics lottoStatistics) {
        return lottoStatistics.totalSecondPrizeWinners();
    }

    public double calculateRateOfProfit(LottoStatistics lottoStatistics, int orderPrice) {
        return lottoStatistics.calculateRateOfProfit(orderPrice);
    }

    public void validation(Lotto lotteries, int bonusBall) {
        boolean isSame = lotteries.getNumbers().stream()
                .anyMatch(number -> number == bonusBall);
        if (!isSame) {
            throw new IllegalArgumentException();
        }
    }

}
