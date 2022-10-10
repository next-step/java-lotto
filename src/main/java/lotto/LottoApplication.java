package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoStatisticsResult;
import lotto.domain.Money;
import lotto.domain.WinningCondition;
import lotto.utils.LottoFactory;
import lotto.utils.LottoStatisticsCalculator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoApplication {

    public static void main(String[] args) {
        Money purchaseAmount = InputView.inputPurchaseAmount();
        int numberOfLottos = (int) purchaseAmount.divideBy(Lotto.PRICE);
        List<Lotto> purchasedLottos = LottoFactory.createLottos(numberOfLottos);
        OutputView.printPurchasedLottos(purchasedLottos);

        WinningCondition winningCondition = InputView.inputWinningCondition();
        LottoStatisticsResult result = LottoStatisticsCalculator.calculateStatistics(winningCondition, purchasedLottos);
        OutputView.printResult(result);
    }

}
