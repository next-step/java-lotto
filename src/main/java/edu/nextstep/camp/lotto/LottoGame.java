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

        final List<Lotto> lottoList = List.of(Lotto.fromIntegers(List.of(1, 2, 3, 4, 5, 6)));
        final Lottos lottosManual = Store.purchase(budget, lottoList);
        final Lottos lottosAuto = Store.purchase(budget.purchased(lottosManual.amount()), AutoLottoGenerator.getInstance());
        OutputView.printPurchasedLotto(lottosAuto);

        final Set<Integer> winningNumbers = InputView.inputWinningNumber();
        final int bonusNumber = InputView.inputBonusNumber();
        final WinningNumber winningNumber = WinningNumber.of(winningNumbers, bonusNumber);
        final GameResult gameResult = lottosAuto.winningResult(winningNumber);
        OutputView.printGameResult(gameResult.collect(), gameResult.totalPrize().toLong(), gameResult.priceEarningRate());
    }
}
