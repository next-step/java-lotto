package lotto;

import lotto.domain.BonusNumber;
import lotto.domain.PurchaseAmountOfMoney;
import lotto.domain.WinningNumbers;
import lotto.domain.lotto.Lottos;
import lotto.domain.WinningAndBonusNumbers;
import lotto.domain.lotto.strategy.AutoGeneratingStrategy;
import lotto.domain.lotto.strategy.LottoGeneratingStrategy;

import static lotto.view.InputView.*;
import static lotto.view.OutputView.*;

public class LottoMain {
    public static void main(String[] arguments) throws Exception {
        try {
            PurchaseAmountOfMoney purchaseAmountOfMoney = enteredPurchaseAmountOfMoney();

            int numberOfLottoToPurchase = purchaseAmountOfMoney.numberOfLottoToPurchase();
            printNumberOfLottoToPurchase(numberOfLottoToPurchase);

            LottoGeneratingStrategy lottoGeneratingStrategy = new AutoGeneratingStrategy();
            Lottos lottos = lottoGeneratingStrategy.lottos(numberOfLottoToPurchase);
            printLottos(lottos.lottos());

            WinningNumbers winningNumbers = enteredWinningNumbers();
            BonusNumber bonusNumber = enteredBonusNumber(winningNumbers);
            WinningAndBonusNumbers winningAndBonusNumbers = WinningAndBonusNumbers.newWinningAndBonusNumbers(winningNumbers, bonusNumber);

            printStatisticsOfLottos(lottos.statistics(winningAndBonusNumbers, purchaseAmountOfMoney));

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
