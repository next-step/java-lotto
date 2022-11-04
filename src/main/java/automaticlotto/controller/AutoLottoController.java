package automaticlotto.controller;

import automaticlotto.domain.Lotto;
import automaticlotto.view.InputView;
import automaticlotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class AutoLottoController {

    private static final Lotto lotto = new Lotto();

    public void startLotto() {
        int purchaseAmount = InputView.enterPurchaseAmount();
        int buyLottoNumbers = OutputView.showLottoNumber(purchaseAmount);
        List<List<String>> buyLotto = new ArrayList<>();
        for (int i = 0; i < buyLottoNumbers; i++) {
            buyLotto.add(lotto.getWinningLotto());
        }
        OutputView.showBuyingLotto(buyLotto);
        String[] winningNumber = InputView.splitWinningNumbers();
        OutputView.winningStatistics(winningNumber, buyLotto, purchaseAmount);
    }

}
