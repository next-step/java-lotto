package lotto;

import lotto.domain.PurchaseAmountOfMoney;
import lotto.domain.WinningNumbers;
import lotto.domain.lotto.Lottos;
import lotto.domain.lotto.strategy.AutoGeneratingStrategy;

import static lotto.view.InputView.enteredPurchaseAmountOfMoney;
import static lotto.view.InputView.enteredWinningNumbers;
import static lotto.view.OutputView.*;

public class LottoMain {
    public static void main(String[] arguments) throws Exception {
        try {
            PurchaseAmountOfMoney purchaseAmountOfMoney = enteredPurchaseAmountOfMoney();
            printNumberOfLottoToPurchase(purchaseAmountOfMoney.numberOfLottoToPurchase());

            Lottos lottos = Lottos.valueOf(purchaseAmountOfMoney);
            lottos.purchaseLotto(new AutoGeneratingStrategy());
            printLottos(lottos.lottos());

            WinningNumbers winningNumbers = enteredWinningNumbers();
            printResultOfLottos(lottos.result(winningNumbers));

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
