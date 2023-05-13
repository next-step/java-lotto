package lotto.controller;

import lotto.domain.LottoMachine;
import lotto.domain.LottoNumber;
import lotto.domain.LottoResultChecker;
import lotto.domain.LottoTicket;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        int amount = inputView.promptPurchaseAmount();

        List<LottoTicket> lottoTickets = LottoMachine.buyLottoTickets(amount);
        resultView.viewBuyingResult(lottoTickets);

        ArrayList<Integer> winningNumbers = inputView.promptWinningNumbers();
        Integer bonusNumber = inputView.promptBonusNumber();
        LottoTicket winnnigTicket = LottoTicket.createWinningTicket(winningNumbers, bonusNumber);
        LottoResultChecker lottoResultChecker = new LottoResultChecker(lottoTickets, winnnigTicket);

        resultView.viewWinningResult(lottoResultChecker);
        resultView.viewRateOfInvestment(amount, lottoResultChecker.getTotalPrizeMoney());
    }
}
