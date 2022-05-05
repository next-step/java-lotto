package lotto;

import lotto.domain.LottoBuyer;
import lotto.dto.input.LastWinningData;
import lotto.dto.result.PurchasedLottos;
import lotto.dto.result.WinningStats;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoSimulator {

    public static void main(String[] args) {
        int purchaseAmount = InputView.purchaseAmountView();

        LottoBuyer lottoBuyer = new LottoBuyer(purchaseAmount);
        lottoBuyer.buyLottos();

        ResultView.purchasedLottosView(PurchasedLottos.from(lottoBuyer));

        String lastWinningLottoNumbers = InputView.lastWinningLottoNumberView();
        lottoBuyer.confirmLottos(new LastWinningData(lastWinningLottoNumbers).toWinningLottoNumbers());

        ResultView.lottosResultView(WinningStats.from(lottoBuyer));
    }
}
