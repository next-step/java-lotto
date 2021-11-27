package edu.nextstep.camp.lotto;

import java.util.Collection;

import edu.nextstep.camp.lotto.domain.AutoLottoGenerator;
import edu.nextstep.camp.lotto.domain.GameResult;
import edu.nextstep.camp.lotto.domain.Lotto;
import edu.nextstep.camp.lotto.domain.PurchaseList;
import edu.nextstep.camp.lotto.view.InputView;
import edu.nextstep.camp.lotto.view.OutputView;

public class LottoStore {
    public static void main(String[] args) {
        final int budget = InputView.inputBudget();
        final PurchaseList purchaseList = PurchaseList.purchase(budget, AutoLottoGenerator.getInstance());
        OutputView.printPurchasedLotto(purchaseList.collect());

        final Collection<Integer> winningNumbers = InputView.inputWinningNumber();
        final GameResult gameResult = purchaseList.winningResult(Lotto.fromIntegers(winningNumbers));
        OutputView.printGameResult(gameResult.collect(), gameResult.totalPrize().toLong(), gameResult.priceEarningRate());
    }
}
