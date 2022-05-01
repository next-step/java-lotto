package lotto;

import lotto.domain.LottoBuyer;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoSimulator {

    public static void main(String[] args) {
        String purchaseAmount = InputView.purchaseAmountView();

        LottoBuyer lottoBuyer = new LottoBuyer(purchaseAmount);
        lottoBuyer.buyLottos();

        ResultView.purchasedLottosView(lottoBuyer.lottos());

        String lastWinningLottoNumbers = InputView.lastWinningLottoNumberView();
        lottoBuyer.confirmLottos(lastWinningLottoNumbers);

        ResultView.lottosResultView(lottoBuyer);
    }
}
