package edu.nextstep.camp.lotto;

import java.util.Collection;

import edu.nextstep.camp.lotto.domain.AutoLottoGenerator;
import edu.nextstep.camp.lotto.domain.GameResult;
import edu.nextstep.camp.lotto.domain.Lotto;
import edu.nextstep.camp.lotto.domain.LottoNumber;
import edu.nextstep.camp.lotto.domain.Lottos;
import edu.nextstep.camp.lotto.domain.Store;
import edu.nextstep.camp.lotto.view.InputView;
import edu.nextstep.camp.lotto.view.OutputView;

public class LottoGame {
    public static void main(String[] args) {
        final int budget = InputView.inputBudget();
        final Lottos lottos = Store.purchase(budget, AutoLottoGenerator.getInstance());
        OutputView.printPurchasedLotto(lottos.collect());

        final Collection<Integer> winningNumbers = InputView.inputWinningNumber();
        final int bonusNumber = InputView.inputBonusNumber();
        final GameResult gameResult = lottos.winningResult(Lotto.fromIntegers(winningNumbers), LottoNumber.of(bonusNumber));
        OutputView.printGameResult(gameResult.collect(), gameResult.totalPrize().toLong(), gameResult.priceEarningRate());
    }
}
