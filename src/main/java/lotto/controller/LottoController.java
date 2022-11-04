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
        int lottoPrice = inputView.priceScan();
        LottoCount count = new LottoCount(lottoPrice);

        resultView.printLottoCount(count);
        List<LottoNumbers> lottoTickets = LottoMachine.createLottoTickets(count);

        resultView.printAllLottoNumbers(lottoTickets);
        getLottoResult(lottoTickets, lottoPrice);
    }

    private void getLottoResult(List<LottoNumbers> lottoTickets, int price) {
        String[] winningNumbers = inputView.lastWeekLottoNumbersScan();
        LottoNumber bonusNumber = new LottoNumber(inputView.bonusNumberScan());

        WinningLottoNumbers winLottoNumbers = new WinningLottoNumbers(new LottoNumbers(LottoUtil.CastingArrayToList(winningNumbers)), bonusNumber);
        LottoResult lottoResult = winLottoNumbers.lottoMatchingResult(lottoTickets);
        resultView.printResult(lottoResult, price);
    }

}
