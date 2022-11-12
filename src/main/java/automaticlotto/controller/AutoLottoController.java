package automaticlotto.controller;

import automaticlotto.domain.Lotto;
import automaticlotto.domain.Lottos;
import automaticlotto.view.InputView;
import automaticlotto.view.OutputView;

import static automaticlotto.domain.Lottos.createLottos;
import static automaticlotto.view.OutputView.showBuyingLottos;

public class AutoLottoController {
    public void startLotto() {
        int purchaseAmount = InputView.enterPurchaseAmount();
        int buyLottoNumbers = OutputView.showLottoNumber(purchaseAmount);
        Lottos lottos = createLottos(buyLottoNumbers);
        showBuyingLottos(lottos);
        Lotto winningLotto = InputView.splitWinningNumbers();
    }

}
