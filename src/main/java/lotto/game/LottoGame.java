package lotto.game;


import lotto.prize.PrizeCount;
import lotto.prize.PrizeCounter;
import lotto.number.LottoBalls;
import lotto.strategy.RandomLottoNumberStrategy;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoGame {
    private final InputView inputView;
    private final ResultView resultView;
    private final LottoMachine lottoMachine;

    public LottoGame(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
        this.lottoMachine = new LottoMachine(new RandomLottoNumberStrategy());
    }

    public void run() {

        int amount = inputView.getAmountFromUser();
        List<LottoBalls> lottoTickets = lottoMachine.generateTickets(amount);

        List<Integer> numbers = inputView.getWinningNumbersFromUser();
        LottoBalls winningNumbers = new LottoBalls(numbers);

        PrizeCounter prizeCounter = new PrizeCounter(lottoTickets, winningNumbers);
        PrizeCount prizeCount = prizeCounter.countPrize();

        resultView.showLottoTickets(lottoTickets);
        resultView.showLottoResult(prizeCount);
        resultView.showLottoProfit(prizeCount.calculateProfitRate(lottoTickets.size()));
    }

}
