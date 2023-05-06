package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoController {

    public void run() {
        int purchaseAmount = InputView.inputPurchaseAmount();
        int manualLottoCount = InputView.inputManualLottoCount();
        List<String> manualLottoNumber = InputView.inputManualLottoNumber(manualLottoCount);

        LottoTickets lottoTickets = LottoTickets.create(purchaseAmount, manualLottoCount, manualLottoNumber);
        ResultView.printLottoTickets(lottoTickets, manualLottoCount);

        String winningNumbersString = InputView.inputWinningNumbers();
        int bonusNumber = InputView.inputBonusNumber();

        LottoGame lottoGame = new LottoGame(lottoTickets, winningNumbersString, bonusNumber);
        WinningStatistics winningStatistics = lottoGame.calculateWinningStatistics();
        double earningsRate = winningStatistics.calculateEarningsRate(lottoTickets.findLottoTicketCount());

        ResultView.printLottoResult(winningStatistics, earningsRate);
    }
}
