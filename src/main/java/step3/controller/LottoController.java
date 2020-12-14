package step3.controller;

import step3.domain.*;
import step3.view.InputView;
import step3.view.ResultView;

import java.util.List;

public class LottoController {
    public void start() {
        ResultView.printPurchasePrice();
        int purchasePrice = InputView.inputPurchasePrice();

        LottoMachine lottoMachine = new LottoMachine();
        List<Lotto> buyLottoList = lottoMachine.buyLotto(purchasePrice);

        int purchaseLottoCount = buyLottoList.size();
        ResultView.printPurchaseCount(purchaseLottoCount);
        ResultView.printLottoNumbers(buyLottoList);

        ResultView.printWinNumber();
        List<LottoNumber> winningLottoNumbers = InputView.inputWinNumber();

        ResultView.printBonusNumber();
        LottoNumber bonusNumber = InputView.inputBonusNumber();

        WinningLotto winningLotto = new WinningLotto(new Lotto(winningLottoNumbers), bonusNumber);

        LottoResult lottoResult = new LottoResult(winningLotto, buyLottoList);

        ResultView.printWinCounts(lottoResult);
        ResultView.printTotalRevenue(lottoResult.getTotalRevenue(purchasePrice));
    }
}
