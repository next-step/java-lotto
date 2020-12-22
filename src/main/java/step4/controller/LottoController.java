package step4.controller;

import step4.domain.*;
import step4.view.InputView;
import step4.view.ResultView;

import java.util.List;

public class LottoController {
    public void start() {
        int purchasePrice = InputView.inputPurchasePrice();
        int manualBuyCount = InputView.inputManualBuyCount();
        LottoTicketCount lottoTicketCount = new LottoTicketCount(purchasePrice, manualBuyCount);

        List<String> manualNumbersList = InputView.inputManualNumbersList(lottoTicketCount.getManualLottoCount());

        LottoMachine lottoMachine = new LottoMachine();
        LottoList buyLottoList = lottoMachine.buyLotto(lottoTicketCount, manualNumbersList);

        ResultView.printLottoTicketCount(lottoTicketCount);
        ResultView.printLottoNumbers(buyLottoList);

        Lotto winningLottoNumbers = new Lotto(InputView.inputWinNumber());

        int bonusNumber = InputView.inputBonusNumber();

        WinningLotto winningLotto = new WinningLotto(winningLottoNumbers, LottoNumber.of(bonusNumber));

        LottoResult lottoResult = new LottoResult(winningLotto, buyLottoList);

        ResultView.printWinCounts(lottoResult);
        ResultView.printTotalRevenue(lottoResult.getTotalRevenue(purchasePrice));
    }
}
