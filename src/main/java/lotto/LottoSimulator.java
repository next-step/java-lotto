package lotto;

import lotto.domain.LottoBuyer;
import lotto.dto.input.BuyerData;
import lotto.dto.input.LastWinningData;
import lotto.dto.result.PurchasedLottos;
import lotto.dto.result.WinningStats;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoSimulator {

    public static void main(String[] args) {
        int purchaseAmount = InputView.purchaseAmountView();

        LottoBuyer lottoBuyer = new LottoBuyer(new BuyerData(purchaseAmount));
        PurchasedLottos purchasedLottos = lottoBuyer.buyLottos();

        ResultView.purchasedLottosView(purchasedLottos);

        String lastWinningLottoNumbers = InputView.lastWinningLottoNumberView();
        WinningStats winningStats = lottoBuyer.confirmLottos(new LastWinningData(lastWinningLottoNumbers));

        ResultView.lottosResultView(winningStats);
    }
}
