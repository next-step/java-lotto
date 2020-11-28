package step2.controller;

import step2.domain.Lotto;
import step2.domain.LottoMachine;
import step2.domain.LottoResult;
import step2.view.InputView;
import step2.view.ResultView;

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
        int[] winNumber = InputView.inputWinNumber();

        LottoResult lottoResult = new LottoResult(winNumber, buyLottoList);
        ResultView.printWinCounts(lottoResult);
        ResultView.printTotalRevenue(lottoResult.getTotalRevenue(purchasePrice));
    }
}
