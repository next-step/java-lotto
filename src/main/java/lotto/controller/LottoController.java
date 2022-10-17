package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoController {
    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();

    public void buyLottoTickets() {
        int lottoPrice = inputView.priceScan();
        LottoCount count = new LottoCount(lottoPrice);

        resultView.printLottoCount(count);
        List<LottoTicket> lottoTickets = LottoTickets.createLottoTickets(count);

        resultView.printAllLottoNumbers(lottoTickets);
        getLottoResult(lottoTickets, lottoPrice);
    }

    private void getLottoResult(List<LottoTicket> lottoTickets, int price) {
        String[] winningNumbers = inputView.lastWeekLottoNumbersScan();
        LastWeekLottoNumbers lottoNumbers = LastWeekLottoNumbers.createLottoNumbers(winningNumbers);

        LottoResult lottoResult = new LottoResult();
        lottoResult.calculateLottoResult(lottoTickets, lottoNumbers, price);

        resultView.printResult(lottoResult);
    }

}
