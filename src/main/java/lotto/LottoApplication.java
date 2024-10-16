package lotto;

import lotto.domain.LottoPurchaseInfo;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.PurchasePrice;
import lotto.domain.WinningNumber;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {
    public static void main(String[] args) {
        final PurchasePrice purchasePrice = new PurchasePrice(InputView.inputPurchasePrice());
        final LottoPurchaseInfo lottoPurchaseInfo = generateLottoPurchaseInfo(purchasePrice);
        final Lottos lottos = new Lottos(InputView.inputManualLottos(lottoPurchaseInfo.getManualCount()), lottoPurchaseInfo);
        ResultView.printLottos(lottos);

        final WinningNumber winningNumber = generateWinningNumber();
        final LottoResult lottoResult = lottos.calculateLottoResult(winningNumber);
        ResultView.printLottoStatistics(lottoResult, purchasePrice);
    }

    private static WinningNumber generateWinningNumber() {
        return new WinningNumber(InputView.inputWinningNumber(), InputView.inputBonusNumber());
    }

    private static LottoPurchaseInfo generateLottoPurchaseInfo(final PurchasePrice purchasePrice) {
        return purchasePrice.calculatePurchaseInfo(InputView.inputManualCount());
    }
}
