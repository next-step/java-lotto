package lotto.controller;

import lotto.domain.LottoMachine;
import lotto.domain.LottoResultChecker;
import lotto.domain.LottoTicket;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.ArrayList;

public class LottoController {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        int amount = inputView.promptPurchaseAmount();

        LottoTicket[] lottoTickets = LottoMachine.buyLottoTickets(amount);
        resultView.viewBuyingResult(lottoTickets);

        ArrayList<Integer> winningNumbers = inputView.promptWinningNumbers();
        LottoResultChecker lottoResultChecker = new LottoResultChecker(lottoTickets, winningNumbers);

        resultView.viewWinningResult(lottoResultChecker);
        resultView.viewRateOfInvestment(amount, lottoResultChecker.getTotalPrizeMoney());
    }
}
