package lotto.game;


import lotto.number.LottoBalls;
import lotto.number.LottoNumber;
import lotto.number.WinningNumbers;
import lotto.prize.PrizeCountMap;
import lotto.prize.PrizeCounter;
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

        int manualLottoCount = inputView.getManualLottoCountFromUser();
        lottoMachine.validateManualLottoCount(amount, manualLottoCount);

        List<List<Integer>> manualLottoNumbers = inputView.getManualLottoNumbers(manualLottoCount);
        List<LottoBalls> lottoTickets = lottoMachine.generateTickets(amount, manualLottoNumbers);

        List<Integer> winningNumbersFromUser = inputView.getWinningNumbersFromUser();
        Integer bonusNumberFromUser = inputView.getBonusNumberFromUser();
        WinningNumbers winningNumbers = new WinningNumbers(new LottoBalls(winningNumbersFromUser), new LottoNumber(bonusNumberFromUser));

        PrizeCounter prizeCounter = new PrizeCounter(lottoTickets, winningNumbers);
        PrizeCountMap prizeCountMap = prizeCounter.countPrize();

        resultView.showLottoTickets(lottoTickets);
        resultView.showLottoResult(prizeCountMap);
        resultView.showLottoProfit(prizeCountMap.calculateProfitRate(lottoTickets.size()));
    }

}
