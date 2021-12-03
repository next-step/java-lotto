package edu.nextstep.camp.lotto;

import java.util.List;
import java.util.Set;

import edu.nextstep.camp.lotto.domain.AutoLottoGenerator;
import edu.nextstep.camp.lotto.domain.Budget;
import edu.nextstep.camp.lotto.domain.GameResult;
import edu.nextstep.camp.lotto.domain.Lotto;
import edu.nextstep.camp.lotto.domain.Lottos;
import edu.nextstep.camp.lotto.domain.Store;
import edu.nextstep.camp.lotto.domain.WinningNumber;
import edu.nextstep.camp.lotto.view.InputView;
import edu.nextstep.camp.lotto.view.OutputView;

public class LottoGame {
    public static void main(String[] args) {
        Budget budget = Budget.of(InputView.inputBudget());

        // todo from input view
        final int manualCount = 1;
        // todo from input view
        final List<Lotto> lottoList = List.of(Lotto.fromIntegers(List.of(1, 2, 3, 4, 5, 6)));
        final Lottos manualLottos = Store.purchase(budget, lottoList);

        if (manualCount != manualLottos.amount())
            throw new IllegalArgumentException("expected amount of manual purchased is " + manualCount + ", but " + manualLottos.amount());

        final Lottos autoLottos = Store.purchase(budget.purchased(manualLottos.amount()), AutoLottoGenerator.getInstance());
        final Lottos purchased = manualLottos.append(autoLottos);
        OutputView.printPurchasedLotto(purchased);

        final Set<Integer> winningNumbers = InputView.inputWinningNumber();
        final int bonusNumber = InputView.inputBonusNumber();
        final WinningNumber winningNumber = WinningNumber.of(winningNumbers, bonusNumber);
        final GameResult gameResult = purchased.winningResult(winningNumber);
        OutputView.printGameResult(gameResult.collect(), gameResult.totalPrize().toLong(), gameResult.priceEarningRate());
    }
}
