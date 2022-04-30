package lotto;

import lotto.domain.LottoManager;
import lotto.domain.Lottos;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoSimulator {

    public static void main(String[] args) {
        String purchaseAmount = InputView.purchaseAmountView();

        Lottos lottos = new LottoManager().createLottos(purchaseAmount);
        ResultView.purchasedLottosView(lottos);

        String lastWinningLottoNumbers = InputView.lastWinningLottoNumberView();
    }
}
