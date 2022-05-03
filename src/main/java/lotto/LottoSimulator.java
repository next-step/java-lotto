package lotto;

import lotto.domain.LottoBuyer;
import lotto.dto.WinningStats;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoSimulator {

    public static void main(String[] args) {
        int purchaseAmount = InputView.purchaseAmountView();

        LottoBuyer lottoBuyer = new LottoBuyer(purchaseAmount);
        lottoBuyer.buyLottos();

        ResultView.purchasedLottosView(lottoBuyer.lottos());

        String lastWinningLottoNumbers = InputView.lastWinningLottoNumberView();
        WinningStats winningStats = lottoBuyer.confirmLottos(lastWinningLottoNumbers);

        ResultView.lottosResultView(winningStats);
    }
}
