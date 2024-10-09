package lotto.game;


import lotto.prize.LottoPrize;
import lotto.result.LottoResult;
import lotto.result.LottoResultStatistics;
import lotto.strategy.RandomLottoNumberStrategy;
import lotto.ticket.LottoTicket;
import lotto.view.InputView;
import lotto.view.ResultView;

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

        LottoResultStatistics lottoResultStatistics = new LottoResultStatistics(lottoTickets, winningNumber);
        Map<LottoResult, Integer> lottoResultIntegerMap = lottoResultStatistics.calculateResult();

        resultView.showLottoResult(lottoResultIntegerMap, lottoPrize);
    }

}
