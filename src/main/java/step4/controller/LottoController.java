package step4.controller;

import step4.domain.*;
import step4.view.InputView;
import step4.view.ResultView;

import java.util.List;

public class LottoController {
    public void start() {
        int purchasePrice = InputView.inputPurchasePrice();

        int manualBuyCount = InputView.inputManualBuyCount();
        List<String> manualNumbersList = InputView.inputManualNumbersList(manualBuyCount);

        LottoMachine lottoMachine = new LottoMachine();
        List<Lotto> buyLottoList = lottoMachine.buyLotto(purchasePrice);

        int purchaseLottoCount = buyLottoList.size();
        ResultView.printPurchaseCount(purchaseLottoCount);
        ResultView.printLottoNumbers(buyLottoList);

        Lotto winningLottoNumbers = new Lotto(InputView.inputWinNumber());

        int bonusNumber = InputView.inputBonusNumber();

        WinningLotto winningLotto = new WinningLotto(winningLottoNumbers, LottoNumber.of(bonusNumber));

        LottoResult lottoResult = new LottoResult(winningLotto, buyLottoList);

        ResultView.printWinCounts(lottoResult);
        ResultView.printTotalRevenue(lottoResult.getTotalRevenue(purchasePrice));
    }
}
