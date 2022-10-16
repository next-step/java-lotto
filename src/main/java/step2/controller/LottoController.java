package step2.controller;

import step2.domain.LottoResult;
import step2.domain.LottoTicket;
import step2.domain.LottoTickets;
import step2.util.LottoUtil;
import step2.view.InputView;
import step2.view.ResultView;

import java.util.List;

public class LottoController {

    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();

    public void buyLottoTickets() {
        int paidAmount = inputView.receiveInputNumber();
        int numOfTickets = LottoUtil.getNumOfTickets(paidAmount);

        resultView.printNumOfTickets(numOfTickets);
        List<LottoTicket> lottoTickets = LottoTickets.createLottoTickets(numOfTickets);

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
