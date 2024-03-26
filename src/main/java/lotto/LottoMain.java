package lotto;

import lotto.domain.*;
import lotto.domain.lotto.Lottos;
import lotto.domain.lotto.strategy.LottoGeneratingStrategy;
import lotto.domain.lotto.strategy.ManualGeneratingStrategy;

import static lotto.view.InputView.*;
import static lotto.view.OutputView.*;

public class LottoMain {
    public static void main(String[] arguments) throws Exception {
        try {
            PurchaseAmountOfMoney purchaseAmountOfMoney = enteredPurchaseAmountOfMoney();
            NumberOfManualLottoToPurchase numberOfManualLottoToPurchase = enteredNumberOfManualLottoToPurchase(purchaseAmountOfMoney.totalNumberOfLottoToPurchase());
            Lottos manualLottos = enteredManualLottos(numberOfManualLottoToPurchase);

            int totalNumberOfLottoToPurchase = purchaseAmountOfMoney.totalNumberOfLottoToPurchase();
            printNumberOfLottoToPurchase(numberOfManualLottoToPurchase.number(), totalNumberOfLottoToPurchase);

            LottoGeneratingStrategy lottoGeneratingStrategy = new ManualGeneratingStrategy();
            Lottos lottos = lottoGeneratingStrategy.lottos(totalNumberOfLottoToPurchase, manualLottos);
            printLottos(lottos.lottos());

            WinningAndBonusNumbers winningAndBonusNumbers = WinningAndBonusNumbers.newWinningAndBonusNumbers(enteredWinningNumbers(), enteredBonusNumber());
            printStatisticsOfLottos(lottos.statistics(winningAndBonusNumbers, purchaseAmountOfMoney));

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
