package edu.nextstep.camp.lotto;

import java.util.Set;

import edu.nextstep.camp.lotto.domain.AutoLottoGenerator;
import edu.nextstep.camp.lotto.domain.GameResult;
import edu.nextstep.camp.lotto.domain.Lottos;
import edu.nextstep.camp.lotto.domain.Store;
import edu.nextstep.camp.lotto.domain.WinningNumber;
import edu.nextstep.camp.lotto.view.InputView;
import edu.nextstep.camp.lotto.view.OutputView;

public class LottoGame {
    public static void main(String[] args) {
        final int budget = InputView.inputBudget();
        final Lottos lottos = Store.purchase(budget, AutoLottoGenerator.getInstance());
        OutputView.printPurchasedLotto(lottos);

        final Set<Integer> winningNumbers = InputView.inputWinningNumber();
        final int bonusNumber = InputView.inputBonusNumber();
        final WinningNumber winningNumber = WinningNumber.of(winningNumbers, bonusNumber);
        final GameResult gameResult = lottos.winningResult(winningNumber);
        OutputView.printGameResult(gameResult.collect(), gameResult.totalPrize().toLong(), gameResult.priceEarningRate());
    }
}
