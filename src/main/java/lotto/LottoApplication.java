package lotto;

import static lotto.view.InputView.askBonusNumber;
import static lotto.view.InputView.askManualNumbers;
import static lotto.view.InputView.askManualPurchaseCount;
import static lotto.view.InputView.askWinningNumbers;
import static lotto.view.InputView.printPurchaseComplete;
import static lotto.view.InputView.askAmount;
import static lotto.view.OutputView.printRanking;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoAmount;
import lotto.domain.Lottos;
import lotto.domain.WinningNumbers;
import lotto.domain.WinningResult;

public class LottoApplication {

    public static void main(String[] args) {
        while (!isEnd()) {
        }
    }

    private static boolean isEnd() {
        try {
            run();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private static void run() {
        LottoAmount amount = LottoAmount.of(askAmount());
        int manualPurchaseCount = askManualPurchaseCount();

        Lottos lottos = Lottos.of(purchaseManualLottoList(manualPurchaseCount), purchaseAutoAmount(amount, manualPurchaseCount));

        printPurchaseComplete(lottos);

        printRanking(WinningResult.of(new WinningNumbers(askWinningNumbers(), askBonusNumber()), lottos), amount);
    }

    private static List<Lotto> purchaseManualLottoList(int manualPurchaseCount) {
        return askManualNumbers(manualPurchaseCount);
    }

    private static LottoAmount purchaseAutoAmount(LottoAmount amount, int manualPurchaseCount) {
        return LottoAmount.of(amount.value() - (manualPurchaseCount * Lottos.LOTTO_AMOUNT));
    }

}
