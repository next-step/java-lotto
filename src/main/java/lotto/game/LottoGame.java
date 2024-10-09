package lotto.game;


import lotto.prize.LottoPrize;
import lotto.calculator.LottoProfitCalculator;
import lotto.result.LottoResult;
import lotto.calculator.LottoResultCalculator;
import lotto.strategy.RandomLottoNumberStrategy;
import lotto.ticket.LottoTicket;
import lotto.view.InputView;
import lotto.view.ResultView;
import lotto.winningnumber.WinningNumber;

import java.util.List;
import java.util.Map;

public class LottoGame {
    private final InputView inputView;
    private final ResultView resultView;
    private final LottoMachine lottoMachine;
    private final LottoPrize lottoPrize;

    public LottoGame(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
        this.lottoMachine = new LottoMachine(new RandomLottoNumberStrategy());
        this.lottoPrize = new LottoPrize();
    }

    public void run() {

        int amount = inputView.getAmountFromUser();
        List<LottoTicket> lottoTickets = lottoMachine.generateTickets(amount);

        List<Integer> winningNumbers = inputView.getWinningNumbersFromUser();
        WinningNumber winningNumber = WinningNumber.from(winningNumbers);

        LottoResultCalculator lottoResultCalculator = new LottoResultCalculator(lottoTickets, winningNumber);
        Map<LottoResult, Integer> lottoResult = lottoResultCalculator.calculateResult();

        LottoProfitCalculator profitCalculator = new LottoProfitCalculator(lottoResult, lottoPrize);
        double profitRate = profitCalculator.calculateProfitRate(lottoTickets.size());

        resultView.showLottoTickets(lottoTickets);
        resultView.showLottoResult(lottoResult, lottoPrize);
        resultView.showLottoProfit(profitRate);
    }

}
