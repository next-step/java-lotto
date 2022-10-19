package lotto;

import java.util.List;

public class LottoMachine {
    private final LottoCalculateStrategy lottoCalculateStrategy;
    public LottoMachine(LottoCalculateStrategy lottoCalculateStrategy) {
        this.lottoCalculateStrategy = lottoCalculateStrategy;
    }

    public List<SelectedLottoes> buyLottoes(Money money) {
        return lottoCalculateStrategy.buyLottoTickets(lottoCalculateStrategy.countLottoTickets(money));
    }

    public Statistics calculateStatistics(List<SelectedLottoes> lottoes, LottoWinningStrategy winningLottoes, Money buyAmount) {
        return lottoCalculateStrategy.calculateStatistics(lottoes, winningLottoes, buyAmount);
    }
}
