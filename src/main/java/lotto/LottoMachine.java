package lotto;

import java.util.List;

public class LottoMachine {
    private final LottoCalculateStrategy lottoCalculateStrategy;
    public LottoMachine(LottoCalculateStrategy lottoCalculateStrategy) {
        this.lottoCalculateStrategy = lottoCalculateStrategy;
    }

    public List<List<Lotto>> buyLottoes(Money money) {
        return lottoCalculateStrategy.buyLottoes(lottoCalculateStrategy.calculateLottoTicketCount(money));
    }

    public Statistics calculateStatistics(List<List<Lotto>> lottoes, List<Lotto> winningLottoes, Money buyAmount) {
        return lottoCalculateStrategy.calculateStatistics(lottoes, winningLottoes, buyAmount);
    }
}
