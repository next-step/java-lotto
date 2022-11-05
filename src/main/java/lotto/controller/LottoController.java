package lotto.controller;

import lotto.domain.*;
import lotto.util.LottoUtil;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoController {
    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();

    public void buyLottoTickets() {
        LottoPrice price = new LottoPrice(inputView.priceScan());
        int manualCount = inputView.manualCountScan();
        LottoCount count = new LottoCount(manualCount, price);

        List<LottoNumbers> lottoTickets = inputView.manualNumberScan(count);

        resultView.printLottoCount(count);
        lottoTickets.addAll(LottoMachine.createLottoTickets(count));

        resultView.printAllLottoNumbers(lottoTickets);
        getLottoResult(lottoTickets, price);
    }

    private void getLottoResult(List<LottoNumbers> lottoTickets, LottoPrice price) {
        String[] winningNumbers = inputView.lastWeekLottoNumbersScan();
        LottoNumber bonusNumber = new LottoNumber(inputView.bonusNumberScan());

        WinningLottoNumbers winLottoNumbers = new WinningLottoNumbers(new LottoNumbers(LottoUtil.CastingArrayToList(winningNumbers)), bonusNumber);
        LottoResult lottoResult = winLottoNumbers.lottoMatchingResult(lottoTickets);
        resultView.printResult(lottoResult, price);
    }

}
