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

        final WinningNumber winningNumber = generateWinningNumber();
        final LottoResult lottoResult = lottos.calculateLottoResult(winningNumber);
        ResultView.printLottoStatistics(lottoResult, lottoPurchaseInfo);
    }

    private static LottoPurchaseInfo generatePurchaseInfo() {
        Optional<LottoPurchaseInfo> lottoPurchaseInfoOptional;
        do {
            final PurchasePrice purchasePrice = generatePurchasePrice();
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

    private static PurchasePrice generatePurchasePrice() {
        Optional<PurchasePrice> purchasePriceOptional;
        do {
            purchasePriceOptional = createPurchasePrice();
        } while (purchasePriceOptional.isEmpty());
        return purchasePriceOptional.get();
    }

    private static Optional<PurchasePrice> createPurchasePrice() {
        try {
            return Optional.of(new PurchasePrice(InputView.inputPurchasePrice()));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return Optional.empty();
        }
    }

    private static WinningNumber generateWinningNumber() {
        return new WinningNumber(InputView.inputWinningNumber(), InputView.inputBonusNumber());
    }
}
