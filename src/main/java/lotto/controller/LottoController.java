package lotto.controller;

import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;
import lotto.util.LottoUtil;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoController {

    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();

    public void buyLotto() {
        int paidAmount = inputView.receiveInputNumber();
        int numOfTickets = LottoUtil.getNumOfTickets(paidAmount);

        resultView.printNumOfTickets(numOfTickets);
        List<LottoTicket> lottoTickets = LottoTickets.create(numOfTickets);

        resultView.printAllLottoNumbers(lottoTickets);
        getLottoResult(lottoTickets, paidAmount);
    }

    private void getLottoResult(List<LottoTicket> lottoTickets, int paidAmount) {
        String winningNumbers = inputView.receiveInputString();
        List<Integer> numbers = LottoUtil.splitStringToNumbers(winningNumbers);

        LottoResult lottoResult = new LottoResult();
        lottoResult.calculateLottoResult(lottoTickets, numbers, paidAmount);

        resultView.printWinningResult(lottoResult);
    }

}
