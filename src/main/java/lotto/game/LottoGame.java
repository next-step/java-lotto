package lotto.game;


import lotto.number.LottoBalls;
import lotto.number.LottoNumber;
import lotto.number.WinningNumbers;
import lotto.prize.PrizeCountMap;
import lotto.prize.PrizeCounter;
import lotto.strategy.AutoLottoNumberStrategy;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private final InputView inputView;
    private final ResultView resultView;
    private final LottoMachine lottoMachine;

    public LottoGame(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
        this.lottoMachine = new LottoMachine(new AutoLottoNumberStrategy());
    }

    public void run() {

        Money amount = inputView.getAmountFromUser();

        LottoCount manualLottoCount = inputView.getManualLottoCountFromUser();
        lottoMachine.validateManualLottoCount(amount, manualLottoCount);

        List<List<Integer>> manualLottoNumbers = inputView.getManualLottoNumbers(manualLottoCount);

        List<LottoBalls> lottoTickets = new ArrayList<>();
        lottoTickets.addAll(lottoMachine.generateManualLottoTicket(manualLottoNumbers));

        LottoCount autoLottoCount = new LottoCount(amount.divideByLottoPrice() - manualLottoNumbers.size());
        lottoTickets.addAll(lottoMachine.generateAutoLottoTicket(autoLottoCount));

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
