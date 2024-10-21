import java.util.Optional;
import lotto.domain.LottoPurchaseInfo;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.PurchasePrice;
import lotto.domain.WinningNumber;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {
    public static void main(String[] args) {
        final LottoPurchaseInfo lottoPurchaseInfo = generatePurchaseInfo();
        final Lottos lottos = new Lottos(InputView.inputManualLottos(lottoPurchaseInfo.getManualCount()),
                lottoPurchaseInfo.calculateAutoCount());
        ResultView.printLottos(lottos, lottoPurchaseInfo);

        final WinningNumber winningNumber = InputView.inputWinningNumber();
        final LottoResult lottoResult = lottos.calculateLottoResult(winningNumber);
        ResultView.printLottoStatistics(lottoResult, lottoPurchaseInfo);
    }

    private static LottoPurchaseInfo generatePurchaseInfo() {
        Optional<LottoPurchaseInfo> lottoPurchaseInfoOptional;
        do {
            final PurchasePrice purchasePrice = InputView.inputPurchasePrice();
            int manualCount = InputView.inputManualCount();
            lottoPurchaseInfoOptional = createLottoPurchaseInfo(purchasePrice, manualCount);
        } while (lottoPurchaseInfoOptional.isEmpty());

        return lottoPurchaseInfoOptional.get();
    }

    private static Optional<LottoPurchaseInfo> createLottoPurchaseInfo(PurchasePrice purchasePrice, int manualCount) {
        try {
            return Optional.of(new LottoPurchaseInfo(purchasePrice, manualCount));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return Optional.empty();
        }
    }
}
