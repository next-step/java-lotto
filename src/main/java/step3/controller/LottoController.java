package step3.controller;

import step3.domain.Lotto;
import step3.domain.LottoMachine;
import step3.domain.WinningLotto;
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

        WinningLotto winningLotto = new WinningLotto(new Lotto(InputView.inputWinNumber()), InputView.inputBonusNumber());
    }
}
